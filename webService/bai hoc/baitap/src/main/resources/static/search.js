$(document).ready(function() {
    $('#search-btn').click(function() {
        let txtSearch = $('#txt-search').val();
        $.ajax({
            type : "GET",
            // gửi data theo path variable
            url:" http://localhost:8080/digital/searchByTitle/"+txtSearch,
            success: function(data) {
                // let tableBody = $('#tblPost tbody');
                // tableBody.empty();
                // $(data).each(function (index, element) {
                //     tableBody.append('<tr><td>' + element.title + '</td><td>' + element.description + '</td><td>' + element.image
                //         + '</td><td>' + element.author + '</td><td>' + element.timePost + '</td><td>' + element.shortDes + '</td></tr>'
                //     )
                // })
                $(data).each(function (index, element) {
                    $('#load_data').append('<h3>' + element.title + '</h3> <p>' + element.description + '</p>'
                    )
                });
            },
            error: function(content) {
                console.log(content);
            }
        });
    });
});


