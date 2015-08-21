$(function () {

    var productListData = [];

    (function init() {


        /*       var result = [{name:'test1'},{name:'test2'}];

         result.forEach(function(item,n) {

         var i = n+2;
         var listHTML =
         '<li role="presentation">' +
         '<a href="#product' + i + '" aria-controls="product' + i + '" role="tab" data-toggle="tab">' + item.name + '</a>' +
         '</li>';
         $('#productList').append(listHTML);

         var operatorHTML =
         '<div role="tabpanel" class="tab-pane" id="product' + i + '">' +
         '<form id="operatorHTML" class="form-horizontal" onsubmit="return false;">' +
         '<div class="form-group">' +
         '<label class="col-sm-3 control-label">设备操作'+i+':</label>' +

         '<div class="col-sm-9">' +
         '<input type="checkbox" checked name="my-checkbox">' +
         '</div>' +
         '</div>' +
         '<div class="form-group">' +
         '<label class="col-sm-3 control-label">定时开关:</label>' +

         '<div class="col-sm-9">' +
         '<input type="checkbox" name="my-checkbox">' +
         '</div>' +
         '</div>' +
         '<div class="form-group">' +
         '<label class="col-sm-3 control-label">定时时间:</label>' +

         '<div class="col-sm-9">' +
         '<input type="number" class="form-control" name="settime">' +
         '</div>' +
         '</div>' +
         '<div class="form-group">' +
         '<div class="col-sm-offset-3 col-sm-9">' +
         '<button type="submit" class="btn btn-primary btn-lg">确定</button>' +
         '</div>' +
         '</div>' +
         '</form>' +
         '<div class="row">' +
         '<div class="col-xs-12">' +
         '<div class="dowebok">' +
         '<div class="hours"></div>' +
         '<div class="minutes"></div>' +
         '<div class="seconds"></div>' +
         '</div>' +
         '</div>' +
         '</div>' +
         '</div>';
         $('#tabContent').append(operatorHTML);
         });
         */

        productListFn();
        // $('.dowebok').flipTimer();
        $('#addProductBtn').on('click', onAddProductBtnClick);
        $('input[name="modelNumber"]').on('blur', onModelNumberInBlur);

    })();


    function productListFn() {
        ajaxRequest('/product/list').done(function (result) {
            productListData = result || [];
            productListData.forEach(function (item, i) {
                var listHTML =
                    '<li role="presentation">' +
                    '<a href="#product' + i + '" aria-controls="product' + i + '" role="tab" data-toggle="tab">' + item.name + '</a>' +
                    '</li>';
                $('#productList').append(listHTML);

                var operatorHTML =
                    '<div role="tabpanel" class="tab-pane" id="product' + i + '">' +
                    '<form id="operatorHTML" class="form-horizontal" onsubmit="return false;">' +
                    '<div class="form-group">' +
                    '<label class="col-sm-3 control-label">设备操作:</label>' +

                    '<div class="col-sm-9">' +
                    '<input type="checkbox" name="operator" checked>' +
                    '</div>' +
                    '</div>' +
                    '<div class="form-group">' +
                    '<label class="col-sm-3 control-label">定时开关:</label>' +

                    '<div class="col-sm-9">' +
                    '<input type="checkbox" name="timing">' +
                    '</div>' +
                    '</div>' +
                    '<div class="form-group">' +
                    '<label class="col-sm-3 control-label">定时时间:</label>' +

                    '<div class="col-sm-9">' +
                    '<input type="number" name="settime" class="form-control">' +
                    '</div>' +
                    '</div>' +
                    '<div class="form-group">' +
                    '<div class="col-sm-offset-3 col-sm-9">' +
                    '<button type="submit" data-index="' + i + '" class="btn btn-primary btn-lg">确定</button>' +
                    '</div>' +
                    '</div>' +
                    '</form>' +
                    '<div class="row">' +
                    '<div class="col-xs-12">' +
                    '<div class="dowebok">' +
                    '<div class="hours"></div>' +
                    '<div class="minutes"></div>' +
                    '<div class="seconds"></div>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>';
                $('#tabContent').append(operatorHTML);
            });
        });
        $('[type="checkbox"]').bootstrapSwitch({onText: '开', offText: '关'});
        $('button[type="submit"]').on('click', onSubmitBtnClick);
    }

    function onAddProductBtnClick(event) {
        var $modelNumber = $('input[name="modelNumber"]');
        var $formGroup = $modelNumber.parents('.form-group');
        if ($formGroup.hasClass('has-error')) {
            return false;
        }
        var param = {modelNumber: $modelNumber.val()};
        ajaxRequest('/userproductrel/add', param).done(function (result) {
            if (result) {
                productListFn();
                console.info('addBtn:', result);
            }
        });
        return false;
    }


    function onSubmitBtnClick(event) {
        var index = $(this).data("index");
        var param = productListData[index];
        var operator = $('input[name="operator"]')[index].checked;
        var timing = $('input[name="timing"]')[index].checked;
        var settime = $('input[name="settime"]')[index].value;
        param.operator = operator;
        ajaxRequest('/operator/send', param).done(function (result) {
            console.info('operator',result);
         });
        return false;
    }

    function onModelNumberInBlur(event) {
        var param = {modelNumber: event.target.value};
        var $formGroup = $(this).parents('.form-group');
        ajaxRequest('/product/isexist', param).done(function (result) {
            $formGroup.removeClass(!result ? 'has-success' : 'has-error');
            $formGroup.addClass(!!result ? 'has-success' : 'has-error');
        });
        return false;
    }


    function ajaxRequest(url, data, async) {
        //url = "/testweb/api/login/login";
        return $.ajax({
            url: '/testweb/api' + url,
            data: data || {},
            type: 'post',
            async: async || false
        }).fail(function (e) {
            console.info('error, e: ', e);
        });
    }


});