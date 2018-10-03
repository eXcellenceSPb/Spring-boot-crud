$(document).ready(function () {
    $("#myInput").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });

    $(".edit").click(function () {
        $("#uid").val($(this).closest("tr").find('.uid').text());
        $("#uname").val($(this).closest("tr").find(".uname").text());
        $("#ulogin").val($(this).closest("tr").find(".ulogin").text());
        $("#upass").val($(this).closest("tr").find(".upass").text());
    });
});