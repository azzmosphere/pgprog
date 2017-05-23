
/**
 * Load a page to a specific DIV.
 */
function loadPage(pagePart, pageToLoad) {
    $(pagePart).load(pageToLoad);
}

function writeContent(pageToLoad) {
    loadPage('#content', pageToLoad);
}


/**
 * sends a request a for the main menu
 */
function generateMenu() {
//    var DIV_POINT = "#content";
//    $.ajax({
//        url: 'views/list',
//        type: "GET",
//        success: function (data) {
//            $.each(data, function (index, item) {
//                $(DIV_POINT).html(
//                    $(DIV_POINT.html() +
//                        "<p <a onclick=\"createChallengeView('" + item.view + "','" + item.id +"');\" class=\"clink\">"
//                        + item.title +
//                        "</p>"
//                );
//            });
//        }
//    });
}
//
//function createChallengeView(view, id) {
//    var urlString = '/challenges/' + id;
//    $.when(
//        writeContent('/' + view),
////        singleValueCreateProcessTrigger(urlString, function () {
////            return {
////                inputString : $('#inputString').val()
////            };
////         }),
//         function () {
//            $.ajax({
//                    url: '/views/challenge/' + id,
//                    type: 'GET',
//                    success: function(data) {
//                    $('#cheading').html(data.challenge.heading);
//                    $('#cdescription').html(data.challenge.description);
//                }
//            });
//         }
//    ).done(function (){
//        console.log("challenge view created with id : " + id ", view : " + view );
//     });
//}
//
////function createProcessTrigger(buttonName, urlString, successMethod, dataMethod) {
////        $(buttonName).click(function () {
////            var data = dataMethod();
////            $.ajax({
////                url: urlString,
////                type: "POST",
////                data: {data : JSON.stringify(data)},
////                success: successMethod,
////                error: function(XMLHttpRequest, textStatus, errorThrown) {
////                    alert("Status: " + textStatus); alert("Error: " + errorThrown);
////                }
////            });
////        });
////}
////
////function buttonPressed() {
////    var canswer
////}
////
////function singleValueCreateProcessTrigger(urlString, dataMethod) {
////    createProcessTrigger('#process', urlString, function (data) {
////        alert('test');
////    }, dataMethod);
////}
////
//

