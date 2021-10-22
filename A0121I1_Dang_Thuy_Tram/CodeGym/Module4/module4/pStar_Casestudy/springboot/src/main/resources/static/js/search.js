$(document).ready((e) => {
    $("#search-button").click(() => {
        let object = $("#object").val();
        $.ajax({
            type:"GET",
            url: '/'+object+'/',
            data : {
                search : $("#search").val(),
            },
            success : (data) => {
                $("#list").html(data)
            }
        })
    })
})