var answerDataTable;
var form;
var activeQuestionId;

function renderShowQuestionBtn(data, type, row) {

    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="answerDataTableInit(' + row.id + ')">Show Answers</a>';
    }
}
function renderDeleteBtn(data, type, row) {

    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="deleteRow(' + row.id + ')">Delete</a>';
    }
}

function renderDeleteAnswrBtn(data, type, row) {

    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="deleteAnswerRow(' + row.id + ')">Delete</a>';
    }
}

function renderAddAnswerBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="addAnswer(' + row.id + ')">Add answer</a>';
    }
}

function addAnswer(id) {
    $('#questionId').val(id);

    form = $('#addAnswerForm');
    form.submit(function () {
        saveAnswer();
        return false;
    });
    $('#addAnswer').modal();
}

function saveAnswer() {
    $.ajax({
        url: 'rest/q/addAnswer',
        type: "POST",
        data: form.serialize(),
        success: function () {
            $('#addAnswer').modal('hide');
            form.find('#questionName1').val('');
            form.find('#isRightAnswer').checked(false);
            updateTable();
        }
    });
    form.unbind('submit');
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

function deleteAnswerRow(id) {

    $.ajax({
        url: 'rest/q/deleteAnswer/' + id,
        method: "DELETE",
        success: function () {
            updateAnswers();
        }
    })

}

function answerDataTableInit(id) {
    if (!(answerDataTable == null))
        answerDataTable.destroy();
    activeQuestionId = id;
    answerDataTable = $('#dataTableAnswers').DataTable({
        ajax: {
            url: 'rest/q/getAnswer/' + activeQuestionId,
            dataSrc: ''
        },
        info: true,
        paging: false,
        filter: false,
        columns: [
            {data: "name"},
            {
                defaultContent: "",
                render: renderDeleteAnswrBtn
            }
        ],
        "createdRow": function (row, data, dataIndex) {
            if (data.right) {
                $(row).css("background-color", "EBF7ED");
            }
        }
    });

    $('#showAnswers').modal();

}

function updateAnswers() {
    $.get('rest/q/getAnswer/' + activeQuestionId, updateAnswerTableByData)
}

function updateAnswerTableByData(data) {
    answerDataTable.clear().rows.add(data).draw();
}

function updateTable() {
    $.get('rest/q/getall', updateTableByData)
}

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}