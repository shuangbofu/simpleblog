window.onload = function() {
    var toTop = document.getElementById("toTop");
    var timer = null;
    var isTop = true;
    var clientHeight = document.documentElement.clientHeight;
    var max = document.body.offsetHeight-clientHeight;


    //滚动条滚动时触发
    window.onscroll = function() {
        var osTop = document.documentElement.scrollTop ||document.body.scrollTop;

        var foothelp = document.getElementById("toTop");
        if(osTop>=clientHeight) {
            foothelp.style.display = 'block';
        } else  {
            foothelp.style.display = 'none';
        }
        if(!isTop) {
            clearInterval(timer);
        }
        isTop = false;
    }

    toTop.onclick = function(){
        //设置定时器
        timer = setInterval(function(){
            //获取滚动条的距离离顶部的高度
            var osTop = document.documentElement.scrollTop ||document.body.scrollTop;
            var speed = Math.floor(-osTop/4);
            document.documentElement.scrollTop = document.body.scrollTop = osTop+speed;
            isTop = true;
            if(osTop==0) {
                clearInterval(timer);
            }
        },30);
    }
}