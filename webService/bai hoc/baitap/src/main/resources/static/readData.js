
    $(document).ready(function () {
        $.ajax({
            type: "GET",
            dataType: 'json',
            // data: {"id": idStudent},
            url: window.location + "digital/listAll",
            success: function (data) {
                let tableBody = $('#tblPost tbody');
                tableBody.empty();
                $(data).each(function (index, element) {
                    tableBody.append('<tr><td>' + element.title + '</td><td>' + element.description + '</td><td>' + element.image
                        + '</td><td>' + element.author + '</td><td>' + element.timePost + '</td><td>' + element.shortDes + '</td></tr>'
                    )
                })
            },
            error: function (content) {
                console.log(content);
            }
        });
    })
   $(document).ready(
       function () {
$ajax({

})
       }
   );


