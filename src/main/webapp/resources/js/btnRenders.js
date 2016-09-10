var answerDataTable;
function renderEditBtn(data, type, row) {

    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="answerDataTableInit(' + row.id + ')">Show Answers</a>';
    }
}
function renderDeleteBtn(data, type, row) {

    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="deleteRow(' + row.id + ')">Delete</a>';
    }
}

function deleteRow(id) {

    $.ajax({
        url: 'rest/q/delete/' + id,
        method: "DELETE",
        success: function () {
            updateTable();
        }
    })

}

function answerDataTableInit(id) {
    if(!(answerDataTable == null))
        answerDataTable.destroy();
    answerDataTable = $('#dataTableAnswers').DataTable({
        ajax: {
            url: 'rest/q/getAnswer/' + id,
            dataSrc: ''
        },
        info: true,
        paging: false,
        filter: false,
        columns: [
            {data: "name"}
        ]
    });

    $('#editRow').modal();

}

function getAnswers(id) {
    $.get('rest/q/getAnswer/' + id, function (data) {
        $.each(data, function (key, value) {
            $.find("span[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

function updateTable() {
    $.get('rest/q/getall', updateTableByData)
}

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}