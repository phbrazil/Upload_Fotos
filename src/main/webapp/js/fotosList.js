

function GetFoodDetails() {
    debugger;
    $.ajax({
        type: "GET",
        url: "http://192.168.0.28:8080/Fotos_Festa/API/getFotos",
        data: {token: "9ember_2020"},
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (result) {
            debugger;

            var jsonResponse = JSON.stringify(result);

            console.log(jsonResponse)
        },
        error: function (response) {
            debugger;
            console.log('eror ' + response);
        }
    });

}
