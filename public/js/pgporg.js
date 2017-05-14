function translate() {
        $('#translate').click(function () {
            alert("button clicked");

            $.ajax({
                url: '/morsecode',
                type: "GET",
                dataType: 'application/json; charset=utf-8',
                success: function (data) {
                    alert(data);
                }
            });
        });
}