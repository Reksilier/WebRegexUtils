$(document).ready(function() {
    $("#clone-replacing").click(function() {
        var lastReplacing = $("input[name='replacings']").last();
        var cloned = lastReplacing.clone();
        cloned.val("");
        cloned.insertAfter(lastReplacing);
    });
});

