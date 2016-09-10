var ajaxUrl = 'rest/q/getall';
var datatableApi;

$(function () {
    datatableApi = $('#dataTable').DataTable({
        ajax: {
            url: ajaxUrl,
            dataSrc: ''
        },
        info: true,
        paging: false,
        filter: false,
        columns: [
            {data: "name"},
            {data: "theme.name"},
            {data: "language.name"},
            {
                defaultContent: "",
                render: renderShowQuestionBtn
            },
            {
                defaultContent: "",
                render: renderDeleteBtn
            },
            {
                defaultContent: "",
                render: renderAddAnswerBtn
            }
        ]
    });

})

