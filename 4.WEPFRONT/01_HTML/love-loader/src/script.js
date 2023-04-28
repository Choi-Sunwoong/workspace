var xmlns = "http://www.w3.org/2000/svg",
  xlinkns = "http://www.w3.org/1999/xlink",
  select = function(s) {
    return document.querySelector(s);
  },
  selectAll = function(s) {
    return document.querySelectorAll(s);
  },
    wholeHeart = select('.wholeHeart'),
    love1 = select('.love1'),
    love2 = select('.love2'),
    love1Shine = select('.love1Shine'),
    love2Shine = select('.love2Shine')
  

TweenMax.set('svg', {
  visibility: 'visible'
})

TweenMax.set([wholeHeart],{
 svgOrigin:'400 300'
})

TweenMax.set( love2,{
 transformOrigin:'50% 50%'
})
TweenLite.defaultEase = Elastic.easeOut.config(0.5,0.7)

var tl = new TimelineMax({paused:false});
tl.to(love1, 1, {
 y:80,
 repeat:-1,
 yoyoEase:Elastic.easeOut.config(0.5,0.7),
 repeatDelay:0
})
.to(love2, 1, {
 x:80,
 repeat:-1,
 yoyoEase:Elastic.easeOut.config(0.5,0.7),
 repeatDelay:0
},0.5)
.to(love2Shine, 1, {
 x:80,
 //rotation:140,
 strokeDashoffset:140,
 repeat:-1,
 //transformOrigin:'50% 50%',
 svgOrigin:'360 300',
 yoyoEase:Elastic.easeOut.config(0.5,0.7),
 repeatDelay:0
},0.5)
.to(love1Shine, 1, {
 y:80,
 //rotation:270,
 strokeDashoffset:70,
 repeat:-1,
 transformOrigin:'50% 50%',
 svgOrigin:'400 260',
 yoyoEase:Elastic.easeOut.config(0.5,0.7),
 repeatDelay:0
},0)


TweenMax.to(wholeHeart, 3, {
 rotation:360,
 repeat:-1,
 ease:Linear.easeNone
 
},0)

//ScrubGSAPTimeline(tl)
//TweenMax.globalTimeScale(0.5)