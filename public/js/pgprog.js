
/**
 * Load a page to a specific DIV.
 */
function loadPage(pagePart, pageToLoad) {
    $(pagePart).load(pageToLoad);
}

function writeContent(pageToLoad) {
    loadPage('#content', pageToLoad);
}