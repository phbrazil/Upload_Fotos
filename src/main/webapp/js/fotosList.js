

function GetFotos(current) {

    console.log('searching new images');
    //debugger;
    $.ajax({
        type: "POST",
        url: "https://www.antigripaischconquistas.com.br/API/getFotos",
        //url: "http://localhost:8080/Fotos_Festa/API/getFotos",
        data: {token: "9ember_2020"},
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept'

        },
        dataType: "json",
        success: function (result) {
            //debugger;

            var json = JSON.stringify(result);

            json = JSON.parse(json);

            for (var k = 0; k < (json.length); k++) {

                if (current.includes(json[k].id)) {

                    console.log("already loaded");

                } else {

                    //add new element to current list
                    current.push(json[k].id);


                    var option_name = '<div class="col-lg-8 offset-lg-2"><div class="blog-post bottom_120">' +
                            '<a class="blog-link" href="#">' +
                            '<figure class="bottom_60">' +
                            '<img src="https://www.cyberoficina.com.br' + json[k].path + '" alt="">' +
                            '</figure>' +
                            '</a>' +
                            '<div class="col-lg-10 offset-lg-1 content-outter">' +
                            '<div class="blog-categories bottom_15">' +
                            ' </div>' +
                            '<h2 class="blog-title bottom_15" id="nome">' + json[k].name + '</h2>' +
                            '<p class="blog-text" id="txt">' + json[k].message + '</p>' +
                            '</div>' +
                            '</div>' +
                            '</div>';

                    $("#messages").append(option_name);


                    var modal = '<div id="modal' + json[k].id + '" class="modal fade bd-example-modal-lg show" tabindex="-1" role="dialog" aria-modal="true" style="padding-right: 17px;">' +
                            '<div class="modal-dialog modal-lg" role="document">' +
                            '<div class="modal-content">' +
                            '<div class="modal-header">' +
                            '<div class="row">' +
                            '</div>' +
                            '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>' +
                            '</div>' +
                            '<div class="modal-body">' +
                            '<div class="container-fluid">' +
                            '<div class="row">' +
                            '<div class="col-md-5 mb-2">' +
                            '<img style="width: 100%;max-width: 200px;max-height: 200px;object-fit: cover;object-position: center;padding: 7px 0;border-radius: 50%;" src="https://www.cyberoficina.com.br' + json[k].path + '" alt="">' +
                            //'<img style="width: 100%;max-width: 200px;max-height: 200px;object-fit: cover;object-position: center;padding: 7px 0;border-radius: 50%;" src="http://localhost:8080/Fotos_Festa' + json[k].path + '" alt="">'+
                            '</div>' +
                            '<div class="col-md-6 text-muted mt-2 mb-2">' +
                            '<div class="row">' +
                            '<h1 style=" font-size: 30px;  padding-bottom: 20px; color: #093970;">' + json[k].name + '</h1>' +
                            '</div>' +
                            '<div class="row">' +
                            '<p>' + json[k].message + '</p>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '<div class="modal-footer"></div>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</div>';

                    $("#modalAppend").append(modal);



                    $('.toast').toast({delay: 20000});
                    $('.toast').toast('show');

                }




            }
        },
        error: function (response) {
            //debugger;
            console.log('error ' + response);
        }
    });

    return current;

}
