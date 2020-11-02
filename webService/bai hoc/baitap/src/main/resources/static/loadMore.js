$(document).ready(function () {

    let limit =7;
    let start = 0;
    let action = 'inactive';

    function load_country_data(limit, start) {
        $.ajax({
            type: "Get",
            dataType: 'json',
            // gửi data theo request param
            data: {"limit": limit, "start": start},
            // data: {"id": idStudent},
            url: window.location + "digital/listAllByLoad",
            success: function (data) {
                // let tableBody = $('#tblPost tbody');
                // tableBody.empty();
                $(data).each(function (index, element) {
                    $('#load_data').append('<h3>' + element.title + '</h3> <p>' + element.description + '</p>'
                    )
                });
                if (data == '') {
                    $('#load_data_message').html("<button type='button' class='btn btn-info'>No Data Found</button>");
                    action = 'active';
                } else {
                    $('#load_data_message').html("<button style='width: 100%' type='button' class='btn btn-warning'>Please Wait....</button>");
                    action = "inactive";
                }
            }
        });
    }

    if (action == 'inactive') {
        action = 'active';
        load_country_data(limit, start);
    }
    $(window).scroll(function () {
        if ($(window).scrollTop() + $(window).height() > $("#load_data").height() && action == 'inactive') {
            action = 'active';
            start = start + limit;
            setTimeout(function () {
                load_country_data(limit, start);
            }, 1000);
        }
    });
});
