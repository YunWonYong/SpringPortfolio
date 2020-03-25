 $(document).ready(function(){
       //이미지 슬라이더
        $(".slider").slick({
			dots: true,
			autoplay: true,
			autoplaySpeed: 3000,
			arrows: true,
			responsive: [
			    {
				    breakpoint: 768,
				    settings: {
				       autoplay:false
			      	}
			    }
			]
			
		});
		 $('.play').on('click',function(){
           $('.slider').slick('slickPlay');
      });
        $('.pause').on('click',function(){
           $('.slider').slick('slickPause');
      });

         $(".slider2").slick({
			dots: true,
			autoplay: false,
			autoplaySpeed: 3000,
			arrows: true,
			responsive: [
			    {
				    breakpoint: 768,
				    settings: {
				       autoplay:false
			      	}
			    }
			]
			
		});
         $(".slider3").slick({
			dots: true,
			autoplay: true,
			autoplaySpeed: 3000,
			arrows: true,
			responsive: [
			    {
				    breakpoint: 768,
				    settings: {
				       autoplay:false
			      	}
			    }
			]
			
		});
         $(".slider4").slick({
			dots: true,
			autoplay: false,
			autoplaySpeed: 3000,
			arrows: true,
			responsive: [
			    {
				    breakpoint: 768,
				    settings: {
				       autoplay:false
			      	}
			    }
			]
			
		});



		 $('.play').on('click',function(){
           $('.slider').slick('slickPlay');
      });
        $('.pause').on('click',function(){
           $('.slider').slick('slickPause');
      });

       


        //라이트 박스
        $("#video-gallery").lightGallery({

        	width: '1300px',
            height: '900px',
            mode: 'lg-fade',
            thumbnail: true,
            autoplay: false,
            pause: 3000,
            progressBar: true,
        }); 
		//sns 공유하기
        $(".instagram").click(function(e){
            e.preventDefault();
            window.open('https://www.instagram.com/nike_snkrs_hongdae/?hl=ko?u=' +encodeURIComponent(document.URL)+'&t='+encodeURIComponent(document.title), 'instagramsharedialog', 'menubar=no, toolbar=no, resizable=yes, scrollbars=yes, height=300, width=600'); 
        });
        $(".twitter").click(function(e){
            e.preventDefault();
            window.open('https://twitter.com/intent/tweet?text=[%EA%B3%B5%EC%9C%A0]%20' +encodeURIComponent(document.URL)+'%20-%20'+encodeURIComponent(document.title), 'twittersharedialog', 'menubar=no, toolbar=no, resizable=yes, scrollbars=yes, height=300, width=600');
        });
        $(".github").click(function(e){
            e.preventDefault();
            window.open('https://github.com/zlibe456/testgit?u=' +encodeURIComponent(document.URL)+'&t='+encodeURIComponent(document.title), 'githubsharedialog', 'menubar=no, toolbar=no, resizable=yes, scrollbars=yes, height=300, width=600'); 
        });
        $(".html").click(function(e){
            e.preventDefault();
            window.open('https://www.w3schools.com/?u=' +encodeURIComponent(document.URL)+'&t='+encodeURIComponent(document.title), 'githubsharedialog', 'menubar=no, toolbar=no, resizable=yes, scrollbars=yes, height=300, width=600'); 
        });



         //음악재생
          const ap = new APlayer({
    container: document.getElementById('aplayer'),
    listFolded: true,
    audio: [
    {
        name: 'blueming',
        artist: '아이유',
        url: '/resources/common/storage/music/iu.mp3',
        cover: '/resources/common/storage/img2/IU.jpg'
    },
    {
        name: '아무노래',//song
        artist: 'zico',//artist name
        url: '/resources/common/storage/music/zico.mp3',//path name and url
        cover: '/resources/common/storage/img2/zico.jpg' //cover image
    },
     {
        name: '1:03',//song
        artist: '넬',//artist name
        url: '/resources/common/storage/music/nell one minit.mp3',//path name and url
        cover: '/resources/common/storage/img2/nell.jpg' //cover image
    },
    {
        name: 'feeling',//song
        artist: 'maroon-5',//artist name
        url: '/resources/common/storage/music/feeling.mp3',//path name and url
        cover: '/resources/common/storage/img2/maroon-5.jpg' //cover image
    },
     {
        name: '고백',//song
        artist: '양다일',//artist name
        url: '/resources/common/storage/music/yangdailConfession.mp3',//path name and url
        cover: '/resources/common/storage/img2/yangdailConfession.jpg' //cover image
    },
    {
        name: '삐삐',//song
        artist: '아이유',//artist name
        url: '/resources/common/storage/music/bibi.mp3',//path name and url
        cover: '/resources/common/storage/img2/bibi.jpg' //cover image
    },
     {
        name: '없어',//song
        artist: '윤하',//artist name
        url: '/resources/common/storage/music/younha_none.mp3',//path name and url
        cover: '/resources/common/storage/img2/younha.jpg', //cover image
    },
    {
        name: '너랑나',//song
        artist: '아이유',//artist name
        url: '/resources/common/storage/music/IU_You_n_me.mp3',//path name and url
        cover: '/resources/common/storage/img2/YouandMe.jpg', //cover image
    },
     {
        name: '이게 무슨 일이야',//song
        artist: 'B1A4',//artist name
        url: '/resources/common/storage/music/B1A4_what_happen.mp3',//path name and url
        cover: '/resources/common/storage/img2/what_happen.jpg', //cover image
    },
     {
        name: '아임 미싱유',//song
        artist: 'SG워너비;',//artist name
        url: '/resources/common/storage/music/SG_imMissingYou.mp3',//path name and url
        cover: '/resources/common/storage/img2/Im_missing.jpg', //cover image
    },
     {
        name: 'Beautiful',//song
        artist: 'Wanna One',//artist name
        url: '/resources/common/storage/music/Wanna_One_Beautiful.mp3',//path name and url
        cover: '/resources/common/storage/img2/beautiful.jpg', //cover image
    },
    {
        name: 'EVERYDAY',//song
        artist: 'WINNER',//artist name
        url: '/resources/common/storage/music/WINNER_EVERYDAY.mp3',//path name and url
        cover: '/resources/common/storage/img2/everyday.png', //cover image
    },
    {
        name: 'FLASH',//song
        artist: 'X1 (엑스원)',//artist name
        url: '/resources/common/storage/music/X1FLASH.mp3',//path name and url
        cover: '/resources/common/storage/img2/flash.jfif', //cover image
    },
    {
        name: 'Another Day',//song
        artist: '먼데이 키즈',//artist name
        url: '/resources/common/storage/music/(Monday Kiz)_(Punch)_Another Day.mp3',//path name and url
        cover: '/resources/common/storage/img2/anotherday.jpg', //cover image
    },
     {
        name: '별 보러 갈래?',//song
        artist: '볼빨간사춘기',//artist name
        url: '/resources/common/storage/music/seeStar.mp3',//path name and url
        cover: '/resources/common/storage/img2/seeStar.jpg', //cover image
    },
    {
        name: '있잖아',//song
        artist: '아이유',//artist name
        url: '/resources/common/storage/music/IUAreyou.mp3',//path name and url
        cover: '/resources/common/storage/img2/Areyou.jpg', //cover image
    },
    {
        name: '너만 너만 너만',//song
        artist: '양다일',//artist name
        url: '/resources/common/storage/music/Yangdail_justYou.mp3',//path name and url
        cover: '/resources/common/storage/img2/justYou.jpg', //cover image
    },
     {
        name: 'Crescendo',//song
        artist: '악동뮤지션',//artist name
        url: '/resources/common/storage/music/Cressendo.mp3',//path name and url
        cover: '/resources/common/storage/img2/Cressendo.jpg' //cover image
    },
    {
        name: 'FINE',//song
        artist: '태연',//artist name
        url: '/resources/common/storage/music/(TAEYEON)_Fine.mp3',//path name and url
        cover: '/resources/common/storage/img2/fine.jfif' //cover image
    },
    {
        name: 'I',//song
        artist: '태연',//artist name
        url: '/resources/common/storage/music/(TAEYEON)_I(Feat).mp3',//path name and url
        cover: '/resources/common/storage/img2/i.jfif' //cover image
    },
     {
        name: '매일 듣는 노래',//song
        artist: '황치열',//artist name
        url: '/resources/common/storage/music/(A Daily Song).mp3',//path name and url
        cover: '/resources/common/storage/img2/(A Daily Song).jpg' //cover image
    },
    {
        name: 'off the record',//song
        artist: 'Will Jay',//artist name
        url: '/resources/common/storage/music/Will Jay_Off The Record.mp3',//path name and url
        cover: '/resources/common/storage/img2/off the record.jfif' //cover image
    },
    {
        name: '우주를 줄게',//song
        artist: '볼빨간사춘기',//artist name
        url: '/resources/common/storage/music/universe.mp3',//path name and url
        cover: '/resources/common/storage/img2/universe.jpg' //cover image
    },
    {
        name: '미리메리크리스마스',//song
        artist: '아이유',//artist name
        url: '/resources/common/storage/music/(IU)_marrychrismas(Feat.of MBLAQ).mp3',//path name and url
        cover: '/resources/common/storage/img2/(IU)_marrychritsmas(Feat.of MBLAQ).png' //cover image
    },
     {
        name: '기적',//song
        artist: '빅스',//artist name
        url: '/resources/common/storage/music/VIXX_(ETERNITY).mp3',//path name and url
        cover: '/resources/common/storage/img2/ETERNITY.jpg' //cover image
    },
    {
        name: '그리워하다',//song
        artist: '비투비',//artist name
        url: '/resources/common/storage/music/B2B_missyou.mp3',//path name and url
        cover: '/resources/common/storage/img2/missyou.jpg' //cover image
    },
     {
        name: 'Martini Blue',//song
        artist: 'DPR LIVE',//artist name
        url: '/resources/common/storage/music/DPR LIVE_Martini Blue.mp3',//path name and url
        cover: '/resources/common/storage/img2/Martini Blue.jfif' //cover image
    },
    {
        name: '워커홀릭',//song
        artist:'볼빨간사춘기',//artist name
        url: '/resources/common/storage/music/workerholic.mp3',//path name and url
        cover: '/resources/common/storage/img2/workerholic.jpg' //cover image
    },
    {
        name: '너없이안된다',//song
        artist:'비투비',//artist name
        url: '/resources/common/storage/music/B2B_notthing_you.mp3',//path name and url
        cover: '/resources/common/storage/img2/B2B_notthing_you.jfif' //cover image
    },
    {
        name: '선물',//song
        artist:'멜로망스',//artist name
        url: '/resources/common/storage/music/(MeloMance)_present.mp3',//path name and url
        cover: '/resources/common/storage/img2/(MeloMance)_present.jpg' //cover image
    },
    ]
});

 //접기/펼치기
        $(".btn").click(function(e){
            e.preventDefault();
            $(".nav").slideToggle();
            $(".btn").toggleClass("open");
            //var btn = $(".btn").find(">i").attr("class");
            //alert(btn);

            if($(".btn").hasClass("open")){
                //open이 있을 때
                $(".btn").find(">i").attr("class","fa fa-angle-up");
            } else {
                //open이 없을 때
                $(".btn").find(">i").attr("class","fa fa-angle-down");
            }
        });

        $(window).resize(function(){
             var wWidth = $(window).width();
             if(wWidth > 600){
             	$(".nav").removeAttr("style");
             }
        });

    });