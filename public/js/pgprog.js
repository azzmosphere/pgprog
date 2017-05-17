
/**
 * Load a page to a specific DIV.
 */
function loadPage(pagePart, pageToLoad) {
    $(pagePart).load(pageToLoad);
}

function writeContent(pageToLoad) {
    loadPage('#content', pageToLoad);
}

function createProcessTrigger(buttonName, urlString, successMethod, dataMethod) {
        $(buttonName).click(function () {
            var data = dataMethod();
            $.ajax({
                url: urlString,
                type: "POST",
                data: {data : JSON.stringify(data)},
                success: successMethod,
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert("Status: " + textStatus); alert("Error: " + errorThrown);
                }
            });
        });
}

function singleValueCreateProcessTrigger(urlString, dataMethod) {
    createProcessTrigger('#process', urlString, function(data) {
        $('#answer').html(data.answer);
    }, dataMethod);
}

