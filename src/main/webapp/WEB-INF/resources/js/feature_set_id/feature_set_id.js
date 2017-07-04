$(function () {
    DataGridManager.init();
})
var DataGridManager = {
    option: {
        striped: true,
        url: "searchAll",
        columns: [[
            {field: 'id', title: '编号', width: 30, aligin: 'left', sortable: true},
            {field: 'name', title: '姓名', width: 30, aligin: 'left', sortable: true},
            {field: 'course', title: '课程', width: 30, align: 'left'},
            {field: 'score', title: '成绩', width: 30, align: 'left'},
        ]],
        pageSize: 30,
        fit: true,
        pagination: true,
        singleSelect: true
    },
    init: function () {
        $('#dg').datagrid(DataGridManager.option);
    }
};
function newUser() {
    $('#fm').form('clear');
    $('#dlg').dialog('open').dialog('center').dialog('setTitle', '申请用户名');
}

function editUser() {
    var row = $('#dg').datagrid('getSelected');
    $('#dlg_edit').dialog('open').dialog('center').dialog('setTitle', '修改页面');
    $('#fm_edit').form('load', row);
}

function doEdit() {
    var id = $("#fm_edit input[name='id']").val();
    var name = $("#fm_edit input[name='name']").val();
    var course = $("#fm_edit input[name='course']").val();
    var score = $("#fm_edit input[name='score']").val();
    var data = {
        id : id,
        name : name,
        course : course,
        score : score
    };

    $.ajax({
        type : "post",
        dataType: "json",
        contentType : 'application/json',
        data: JSON.stringify(data),
        url : "updateOne",
        success : function (result) {
            if(result.msg == "error"){
                $.messager.show({
                    title : 'Error'
                });
            } else {
                $('#dlg_edit').dialog('close');
                $('#dg').datagrid('reload');
            }
        }
    });

}

function saveUser() {
    var name = $("#fm input[name='user_name']").val();
    var course = $("#fm input[name='user_course']").val();
    var score = $("#fm input[name='user_score']").val();
    var data = {
        name: name,
        course: course,
        score: score
    };
    $.ajax({
        type: "post",
        dataType: "json",
        contentType: 'application/json',
        data: JSON.stringify(data),
        url: "addOne",
        success: function (result) {
            if (result.msg == "error") {
                $.messager.show({
                    title: 'Error'
                });
            } else {
                $('#dlg').dialog('close');        // close the dialog
                $('#dg').datagrid('reload');    // reload the user data
            }
        }
    });
}

function destroyUser() {
    var row = $('#dg').datagrid('getSelected');
    var id = row.id;
    if (row) {
        $.messager.confirm('Confirm', 'Are you sure you want to delete this info?', function (r) {
            if (r) {
                $.ajax({
                    type: "post",
                    dataType: "json",
                    contentType: 'application/json',
                    data: id,
                    url: "deleteOne",
                    success: function (result) {
                        if (result) {
                            $('#dg').datagrid('reload');
                        }
                    }
                });
            }
        });
    }
}

function searchUser() {
    var row = $('#dg').datagrid('getSelected');
    $('#dlg_check').dialog('open').dialog('center').dialog('setTitle', '修改页面');
    $('#fm_check').form('load', row);
}