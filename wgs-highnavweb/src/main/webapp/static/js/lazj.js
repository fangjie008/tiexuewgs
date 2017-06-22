$(document).ready(function () {
    //懒加载
    lazyDownload("#js_content");
});
$(window).scroll(function () {
    //懒加载
    lazyDownload("#js_content");

});

function lazyDownload(selector) {
    var sh = $(window).height();
    var imgs = $(selector).find("img[data-src]");

    imgs.each(function () {
        var self = $(this);
        var a = self.offset().top;
        var h = sh + $(document).scrollTop() - a;

        if (h >= -100) {
            self.attr("src", self.attr("data-src"));
            self.removeAttr("data-src");
            self.removeAttr("height");
        }
    });
}