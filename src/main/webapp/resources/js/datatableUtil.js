var datatableApi;

$(function () {
    datatableApi = $('#dataTable').DataTable({
        ajax: {
            url: 'rest/q/getall',
            dataSrc: ''
        },
        info: true,
        pagingType: "full_numbers",
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

