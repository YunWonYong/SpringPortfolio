	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"
	language="java" pageEncoding="UTF-8"%>
<html>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
    <meta name="author" content="webstoryboy">
    <meta name="description" content="반응형 사이트 따라하기">
    <meta name="keywords" content="반응형사이트, 웹퍼블리셔, 웹접근성, HTML5, webstoryboy, webs">
    <title>반응형 사이트 만들기</title>

    <!-- style -->
    <link rel="stylesheet" href="/resources/css/index/reset.css">
    <link rel="stylesheet" href="/resources/css/index/style.css">
    <link rel="stylesheet" href="/resources/css/index/slick.css">
    <link rel="stylesheet" href="/resources/css/index/lightgallery.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Facebook meta tags -->
    <meta property="og:type" content="article" />
    <meta property="og:title" content="반응형 사이트 만들기(title)" />
    <meta property="og:url" content="http://richclub8.dothome.co.kr/responsive/html5/index.html" />
    <meta property="og:image" content="http://richclub8.dothome.co.kr/assets/ico/icon.png" />
    <meta property="og:site_name" content="반응형 사이트 만들기(site_name)" />
    <meta property="og:description" content="반응형 사이트 따라하기(description)" />

    <!-- twitter meta tags -->
    <meta name="twitter:card" content="summary_large_image" />
    <meta name="twitter:site" content="@webstoryboy" />
    <meta name="twitter:title" content="반응형 사이트 만들기(title)" />
    <meta name="twitter:description" content="반응형 사이트 만들기(description)." />
    <meta property="twitter:image" content="http://richclub8.dothome.co.kr/assets/ico/icon.png" />

    <!-- 파비콘 -->
    <link rel="icon"  href="/resources/icon/index/favicon-64.png">
    <link rel="icon" href="/resources/icon/index/favicon-16.png" sizes="16x16"> 
    <link rel="icon" href="/resources/icon/index/favicon-32.png" sizes="32x32"> 
    <link rel="icon" href="/resources/icon/index/favicon-48.png" sizes="48x48"> 
    <link rel="icon" href="/resources/icon/index/favicon-64.png" sizes="64x64"> 
    <link rel="icon" href="/resources/icon/index/favicon-128.png" sizes="128x128">
   
<!-- 웹 폰트 -->
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Abel" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/aplayer/1.10.1/APlayer.min.css">



<head>
<!-- <title>Home</title> -->
</head>

<nav id="nav">
		<div class="container">
			<div class="row">
				<div class="nav">
					<h2 class="ir_su">전체 메뉴</h2>
					<div>
			            <h3>HTML Reference</h3>
			            <ol>
			                <li><a href="#">HTML 태그(Tag)</a></li>
			                <li><a href="#">블록 요소/인라인 요소</a></li>
			                <li><a href="#">DTD 선언</a></li>
			                <li><a href="#">언어 속성 설정</a></li>
			                <li><a href="#">HTML &lt;title&gt;</a></li>
			                <li><a href="#">HTML &lt;meta&gt;</a></li>
			                <li><a href="#">특수문자</a></li>
			                <li><a href="#">하이퍼 링크</a></li>
			                <li><a href="#">HTML &lt;style&gt;</a></li>
			                <li><a href="#">HTML &lt;html&gt;</a></li>
			                <li><a href="#">HTML &lt;head&gt;</a></li>
			                <li><a href="#">HTML &lt;div&gt;</a></li>
			                <li><a href="#">HTML &lt;colgroup&gt;</a></li>
			                <li><a href="#">HTML &lt;caption&gt;</a></li>
			            </ol>
			        </div>
			        <div>
			            <h3>CSS Reference</h3>
			            <ol>
			                <li><a href="#">CSS 선택자</a></li>
			                <li><a href="#">CSS 단위</a></li>
			                <li><a href="#">CSS 색상</a></li>
			                <li><a href="#">CSS 선언 방법</a></li>
			                <li><a href="#">상대주소와 절대주소</a></li>
			                <li><a href="#">CSS float</a></li>
			                <li><a href="#">이미지 표현 방법</a></li>
			                <li><a href="#">이미지 스프라이트</a></li>
			                <li><a href="#">IR 효과</a></li>
			                <li><a href="#">이미지 최적화</a></li>
			                <li><a href="#">background-color</a></li>
			                <li><a href="#">border-style</a></li>
			                <li><a href="#">font-size</a></li>
			                <li><a href="#">text-align</a></li>
			            </ol>
			        </div>
			        <div>
			            <h3>Responsive</h3>
			            <ol>
			                <li><a href="#">반응형사이트</a></li>
			                <li><a href="#">미디어쿼리</a></li>
			                <li><a href="#">CSS3</a></li>
			                <li><a href="#">웹 접근성 연구소</a></li>
			                <li><a href="#">네이버 널리</a></li>
			                <li><a href="#">다음 다룸</a></li>
			                <li><a href="#">Webstandard</a></li>
			            </ol>
			        </div>
				</div>
			</div>
		</div>
	</nav>

<article id="title">
	<div class="container">
		<div class="title">
			<h2>"나는 웹 퍼블리셔다"</h2>
			<a href="#" class="btn"><i class="fa fa-angle-down" aria-hidden="true"></i>
              <span class="ir_su">전체메뉴 보기</span>
			</a>
		</div>
	</div>
</article>
<!--//title-->

<main>
<section id="contents">
	<div class="container">
		<h2 class="ir_su">반응형 사이트 컨텐츠</h2>

	<section id="con_left">
		<h3 class="ir_su">빈응형 사이트 왼쪽 컨텐츠</h3>
		<article class="column col1">
			<h4 class="col_tit"><span>M</span><span>e</span><span>n</span><span>u</span></h4>
			<p class="col_desc">box-shadow를 이용한 마우스 오버 효과입니다.</p>
			<!-- 메뉴 -->
            <div class="menu">
            <ul>
								<li><a href="#">지니차트 <i class="fa fa-angle-double-right" aria-hidden="true"></i></a></li>
								<li><a href="#">최신음악 <i class="fa fa-angle-double-right" aria-hidden="true"></i></a></li>
								<li><a href="#">장르음악 <i class="fa fa-angle-double-right" aria-hidden="true"></i></a></li>
								<li><a href="#">매거진 <i class="fa fa-angle-double-right" aria-hidden="true"></i></a></li>
								<li><a href="#">추천 <i class="fa fa-angle-double-right" aria-hidden="true"></i></a></li>
								<li><a href="#">뮤작허그 <i class="fa fa-angle-double-right" aria-hidden="true"></i></a></li>
							</ul>
            </div>
			<!-- //메뉴 -->
		</article>
		<!-- //col1 -->
		<article class="column col2">
			<!-- <h4 class="col_tit">Notice</h4> -->
		<!-- 	<p class="col_desc">게시판 영역의 한줄 효과와 두줄 효과 입니다.</p> -->
			<!-- 게시판 -->
			      <div class="slider4">
                	<div>

                		<!-- <figure>
                		<iframe width="560" height="315" src="https://www.youtube.com/embed/nM0xDI5R50E" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                		</figure> -->
                        <figure>
                        	<a href="https://www.naver.com/"><img src="/resources/common/storage/img2/music.jpg"></a>
                        	<figcaption><em>NAVER</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span></figcaption>
                        </figure> 
                	</div>
                	<div>
                	<!-- 	<figure>
                	<iframe width="560" height="315" src="https://www.youtube.com/embed/d9IxdwEFk1c" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                	</figure> -->
                		<figure>
                        	<img src="/resources/common/storage/img2/pic.jpg">
                        	<figcaption><em>Responsive Site2</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span>
                        	</figcaption>
                        </figure> 
                    </div>
                	<div class="movie1">
                		<!--<figure>
                        <iframe width="560" height="315" src="https://www.youtube.com/embed/Uvnru8qalXQ" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                        </figure> -->
                		<figure>
                        	<img src="/resources/common/storage/img2/girl.jpg">
                        	<figcaption><em>Responsive Site3</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span></figcaption>
                        </figure>

                    </div>

                </div>
                <div class="slider4">
                	<div>

                		<!-- <figure>
                		<iframe width="560" height="315" src="https://www.youtube.com/embed/nM0xDI5R50E" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                		</figure> -->
                        <figure>
                        	<a href="https://www.naver.com/"><img src="/resources/common/storage/img2/music.jpg"></a>
                        	<figcaption><em>NAVER</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span></figcaption>
                        </figure> 
                	</div>
                	<div>
                	<!-- 	<figure>
                	<iframe width="560" height="315" src="https://www.youtube.com/embed/d9IxdwEFk1c" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                	</figure> -->
                		<figure>
                        	<img src="/resources/common/storage/img2/pic.jpg">
                        	<figcaption><em>Responsive Site2</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span>
                        	</figcaption>
                        </figure> 
                    </div>
                	<div class="movie1">
                		<!--<figure>
                        <iframe width="560" height="315" src="https://www.youtube.com/embed/Uvnru8qalXQ" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                        </figure> -->
                		<figure>
                        	<img src="/resources/common/storage/img2/girl.jpg">
                        	<figcaption><em>Responsive Site3</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span></figcaption>
                        </figure>

                    </div>

                </div>
             <!-- <div class="notice1">
             	<h5>Notice1</h5>
             	<ul>
             		<li><a href="#">이 줄은 한 줄 효과입니다. 이 줄은 한 줄 효과입니다.</a></li>
             		<li><a href="#">이 줄은 한 줄 효과입니다. 이 줄은 한 줄 효과입니다.</a></li>
             		<li><a href="#">이 줄은 한 줄 효과입니다. 이 줄은 한 줄 효과입니다.</a></li>
             		<li><a href="#">이 줄은 한 줄 효과입니다. 이 줄은 한 줄 효과입니다.</a></li>
             	</ul>
             	<a href="#" class="more" title="더 보기">More <i class="fa fa-plus-circle" aria-hidden="true"></i></a>
             </div> -->
             <!-- //게시판 -->
             <!-- 게시판2 -->

                    <!-- <div class="notice2 mt15" >
                    	<h5>Notice2</h5>
                                 	<ul>
                                 		<li><a href="#">이 줄은 한 줄 효과입니다. 이 줄은 한 줄 효과입니다. 이 줄은 한 줄 효과입니다.</a></li>
                                 		<li><a href="#">이 줄은 한 줄 효과입니다. 이 줄은 한 줄 효과입니다. 이 줄은 한 줄 효과입니다.</a></li>
                                 		<li><a href="#">이 줄은 한 줄 효과입니다. 이 줄은 한 줄 효과입니다. 이 줄은 한 줄 효과입니다.</a></li>
                                 		<li><a href="#">이 줄은 한 줄 효과입니다. 이 줄은 한 줄 효과입니다. 이 줄은 한 줄 효과입니다.</a></li>
                                 	</ul>
                                 	<a href="#" class="more" title="더 보기">More <i class="fa fa-plus-circle" aria-hidden="true"></i></a>
                                 </div> -->
			<!-- // --> 
		</article>
			<!-- //col2 -->
		<article class="column col3">
			<h4 class="col_tit">Blog</h4>
			<p class="col_desc">해상도에 따라 이미지를 다르게 표현하는 방법입니다.</p>
			<!-- blog1 -->
                 <div class="blog1">
                 	<h5 class="ir_su">image1</h5>
                 	<figure>
                 		<!-- <img src="img/blog1_@1.jpg" class="img-normal" alt="normal image">
                 		<img src="img/blog1_@2.jpg" class="img-retina" alt="retina image" width="100%"> -->
                 		<img src="/resources/common/storage/img2/blog3_@3.jpg" srcset="/resources/common/storage/img2/blog3_@3.jpg 1x, img/blog3_@3.jpg 2x,/resources/common/storage/img2/blog3_@3.jpg 3x" alt="normal">
                 		<figcaption>반응형 웹 사이트 이미지  글입니다. 반응형 웹 사이트 이미지 글입니다. <br>
                 		반응형 웹 사이트 이미지  글입니다. 반응형 웹 사이트 이미지 글입니다.</figcaption>
                 	</figure>
                 </div>
			<!-- //blog1 --> 
			<!-- blog2 -->
                 <div class="blog2 mt15">

                 	<figure>
                 		<!-- <img src="img/blog1_@1.jpg" class="img-normal" alt="normal image">
                 		<img src="img/blog1_@2.jpg" class="img-retina" alt="retina image" width="100%"> -->
                 		
                 		<img src="/resources/common/storage/img2/blog3_@3.jpg" srcset="/resources/common/storage/img2/blog3_@3.jpg 1x, img/blog3_@3.jpg 2x,/resources/common/storage/img2/blog3_@3.jpg 3x" alt="normal">
                 		<figcaption>반응형 웹 사이트 이미지  글입니다. 반응형 웹 사이트 이미지 글입니다.</figcaption>
                 		<figcaption>반응형 웹 사이트 이미지  글입니다. 반응형 웹 사이트 이미지 글입니다.</figcaption>
                 		
                 	</figure>
                 	
                 	<!-- <div class="img-retina">
                 		<h5>image2</h5>
                 	<figcaption>반응형 웹 사이트 이미지  글입니다. 반응형 웹 사이트 이미지 글입니다. 반응형 웹 사이트 이미지 글입니다.</figcaption>
                 	</div> -->
                 	
                 </div>
                 <figure>
                 		<!-- <img src="img/blog1_@1.jpg" class="img-normal" alt="normal image">
                 		<img src="img/blog1_@2.jpg" class="img-retina" alt="retina image" width="100%"> -->
                 		
                 		<img src="/resources/common/storage/img2/blog3_@3.jpg" srcset="/resources/common/storage/img2/blog3_@3.jpg 1x, img/blog3_@3.jpg 2x,/resources/common/storage/img2/blog3_@3.jpg 3x" alt="normal">
                 		<figcaption>반응형 웹 사이트 이미지  글입니다. 반응형 웹 사이트 이미지 글입니다.</figcaption>
                 		<figcaption>반응형 웹 사이트 이미지  글입니다. 반응형 웹 사이트 이미지 글입니다.</figcaption>
                 		
                 	</figure>

			<!-- //blog2 --> 
		</article>
	</section>
	<section  id="con_center">
		<h3 class="ir_su">반응형 사이트 가운데 컨텐츠</h3>
			<!-- //col3 -->
		<article class="column col4">
			<h4 class="col_tit">Slick Slider</h4>
			<p class="col_desc">slick.js를 이용한 이미지 슬라이드 효과입니다.</p>
			<!-- 이미지 슬라이드 -->
                <div class="slider">
                	<div>

                		<!-- <figure>
                		<iframe width="560" height="315" src="https://www.youtube.com/embed/nM0xDI5R50E" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                		</figure> -->
                        <figure>
                        	<a href="https://www.naver.com/"><img src="/resources/common/storage/img2/music.jpg"></a>
                        	<figcaption><em>NAVER</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span></figcaption>
                        </figure> 
                	</div>
                	<div>
                	<!-- 	<figure>
                	<iframe width="560" height="315" src="https://www.youtube.com/embed/d9IxdwEFk1c" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                	</figure> -->
                		<figure>
                        	<img src="/resources/common/storage/img2/pic.jpg">
                        	<figcaption><em>Responsive Site2</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span>
                        	</figcaption>
                        </figure> 
                    </div>
                	<div class="movie1">
                		<!--<figure>
                        <iframe width="560" height="315" src="https://www.youtube.com/embed/Uvnru8qalXQ" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                        </figure> -->
                		<figure>
                        	<img src="/resources/common/storage/img2/girl.jpg">
                        	<figcaption><em>Responsive Site3</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span></figcaption>
                        </figure>

                    </div>

                </div>
			<!-- //이미지 슬라이드 --> 
			
		</article>






		<article class="column col6">
			<!-- <h4 class="col_tit">Video</h4>
			<p class="col_desc">반응형 영상을 보여주는 영역입니다.</p> -->
			<!-- video -->
                <!--  <video autoplay="autoplay" controls="controls" loop="loop">
                	<source src="img/blueming.mp4" type="video/mp4">
                </video> -->

                <h4 class="col_tit">Slick Slider</h4>
			<p class="col_desc">slick.js를 이용한 이미지 슬라이드 효과입니다.</p>
			<!-- 이미지 슬라이드 -->
                <div class="slider3">

                	   	<div>


                		<div id="video-gallery" class="  square clearfix">
                			<h5>뮤직비디오</h5>
						<a data-src="https://www.youtube.com/embed/nM0xDI5R50E" data-iframe="true" id="open-website"><img src="/resources/common/storage/img2/bibi.jpg" alt="이미지"><em>blur</em></a>

					<a data-src="https://www.youtube.com/embed/d9IxdwEFk1c/" data-iframe="true" id="open-website"><img src="/resources/common/storage/img2/palette.jpg" alt="이미지"><em>brightness</em></a>

						<a data-src="https://www.youtube.com/embed/Uvnru8qalXQ" data-iframe="true" id="open-website"><img src="/resources/common/storage/img2/yangdailConfession.jpg" alt="이미지"><em>contrast</em></a>

						<a data-src="https://www.youtube.com/embed/D1PvIWdJ8xo" data-iframe="true" id="open-website"><img src="/resources/common/storage/img2/blueming.jpg" alt="이미지"><em>hur-rotate</em></a>

						<a data-src="https://www.youtube.com/embed/yqtCGojXEpM" data-iframe="true" id="open-website"><img src="/resources/common/storage/img2/IU.jpg" alt="이미지"><em>grayscale</em></a>

						<a data-src="https://www.youtube.com/embed/UuV2BmJ1p_I" data-iframe="true" id="open-website"><img src="/resources/common/storage/img2/zico.jpg" alt="이미지"><em>invert</em></a>

						<a data-src="https://www.youtube.com/embed/OxgiiyLp5pk" data-iframe="true" id="open-website"><img src="/resources/common/storage/img2/WildFlower.jpg" alt="이미지"><em>opacity</em></a>

						<a data-src="https://www.youtube.com/embed/NJR8Inf77Ac" data-iframe="true" id="open-website"><img src="/resources/common/storage/img2/YouandMe.jpg" alt="이미지"><em>saturate</em></a>

						<a href="/resources/common/storage/img2/light09_s.jpg"><img src="/resources/common/storage/img2/light09.jpg" alt="이미지"><em>sepia</em></a>
						<a href="/resources/common/storage/img2/light10_s.jpg"><img src="/resources/common/storage/img2/light10.jpg" alt="이미지"><em>Mix</em></a>
					</div>



                		<!-- <figure>
                		<iframe width="560" height="315" src="https://www.youtube.com/embed/d9IxdwEFk1c" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                		</figure> -->


                		<!--<figure>
                        	<img src="img/slider001.jpg">
                        	<figcaption><em>Responsive Site2</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span>
                        	</figcaption>
                        </figure> -->
                    </div>






           <div >
   
                		<div id="video-gallery"  class="  square clearfix">
						<a href="https://www.youtube.com/embed/Uvnru8qalXQ"><img src="/resources/common/storage/img2/bibi.jpg" alt="이미지"><em>blur</em></a>
					<a href="https://www.youtube.com/embed/Uvnru8qalXQ"><img src="/resources/common/storage/img2/palette.jpg" alt="이미지"><em>brightness</em></a>
						<a href="https://www.youtube.com/embed/nM0xDI5R50E"><img src="/resources/common/storage/img2/yangdailConfession.jpg" alt="이미지"><em>contrast</em></a>
						<a href="https://www.naver.com/"><img src="/resources/common/storage/img2/blueming.jpg" alt="이미지"><em>hur-rotate</em></a>
						<a href="/resources/common/storage/img2/light05_s.jpg"><img src="/resources/common/storage/img2/IU.jpg" alt="이미지"><em>grayscale</em></a>
						<a href="/resources/common/storage/img2/light06_s.jpg"><img src="/resources/common/storage/img2/zico.jpg" alt="이미지"><em>invert</em></a>
						<a href="/resources/common/storage/img2/light07_s.jpg"><img src="/resources/common/storage/img2/light07.jpg" alt="이미지"><em>opacity</em></a>
						<a href="/resources/common/storage/img2/light08_s.jpg"><img src="/resources/common/storage/img2/light08.jpg" alt="이미지"><em>saturate</em></a>
						<a href="/resources/common/storage/img2/light09_s.jpg"><img src="/resources/common/storage/img2/light09.jpg" alt="이미지"><em>sepia</em></a>
						<a href="/resources/common/storage/img2/light10_s.jpg"><img src="/resources/common/storage/img2/light10.jpg" alt="이미지"><em>Mix</em></a>
					</div>



                		<!-- <figure>
                		<iframe width="560" height="315" src="https://www.youtube.com/embed/d9IxdwEFk1c" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                		</figure> -->


                		<!--<figure>
                        	<img src="img/slider001.jpg">
                        	<figcaption><em>Responsive Site2</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span>
                        	</figcaption>
                        </figure> -->
                    </div>
                	<div>


                		<div id="video-gallery" class="  square clearfix">
						<a href="https://www.youtube.com/embed/Uvnru8qalXQ"><img src="/resources/common/storage/img2/bibi.jpg" alt="이미지"><em>blur</em></a>
					<a href="https://www.youtube.com/embed/Uvnru8qalXQ"><img src="/resources/common/storage/img2/palette.jpg" alt="이미지"><em>brightness</em></a>
						<a href="https://www.youtube.com/embed/nM0xDI5R50E"><img src="/resources/common/storage/img2/yangdailConfession.jpg" alt="이미지"><em>contrast</em></a>
						<a href="https://www.naver.com/"><img src="/resources/common/storage/img2/blueming.jpg" alt="이미지"><em>hur-rotate</em></a>
						<a href="/resources/common/storage/img2/light05_s.jpg"><img src="/resources/common/storage/img2/IU.jpg" alt="이미지"><em>grayscale</em></a>
						<a href="/resources/common/storage/img2/light06_s.jpg"><img src="/resources/common/storage/img2/zico.jpg" alt="이미지"><em>invert</em></a>
						<a href="/resources/common/storage/img2/light07_s.jpg"><img src="/resources/common/storage/img2/light07.jpg" alt="이미지"><em>opacity</em></a>
						<a href="/resources/common/storage/img2/light08_s.jpg"><img src="/resources/common/storage/img2/light08.jpg" alt="이미지"><em>saturate</em></a>
						<a href="/resources/common/storage/img2/light09_s.jpg"><img src="/resources/common/storage/img2/light09.jpg" alt="이미지"><em>sepia</em></a>
						<a href="/resources/common/storage/img2/light10_s.jpg"><img src="/resources/common/storage/img2/light10.jpg" alt="이미지"><em>Mix</em></a>
					</div>



                		<!-- <figure>
                		<iframe width="560" height="315" src="https://www.youtube.com/embed/d9IxdwEFk1c" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                		</figure> -->


                		<!--<figure>
                        	<img src="img/slider001.jpg">
                        	<figcaption><em>Responsive Site2</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span>
                        	</figcaption>
                        </figure> -->
                    </div>
                <div>


                		<div id="video-gallery" class="  square clearfix">
						<a href="https://www.youtube.com/embed/Uvnru8qalXQ"><img src="/resources/common/storage/img2/bibi.jpg" alt="이미지"><em>blur</em></a>
					<a href="https://www.youtube.com/embed/Uvnru8qalXQ"><img src="/resources/common/storage/img2/palette.jpg" alt="이미지"><em>brightness</em></a>
						<a href="https://www.youtube.com/embed/nM0xDI5R50E"><img src="/resources/common/storage/img2/yangdailConfession.jpg" alt="이미지"><em>contrast</em></a>
						<a href="https://www.naver.com/"><img src="/resources/common/storage/img2/blueming.jpg" alt="이미지"><em>hur-rotate</em></a>
						<a href="/resources/common/storage/img2/light05_s.jpg"><img src="/resources/common/storage/img2/IU.jpg" alt="이미지"><em>grayscale</em></a>
						<a href="/resources/common/storage/img2/light06_s.jpg"><img src="/resources/common/storage/img2/zico.jpg" alt="이미지"><em>invert</em></a>
						<a href="/resources/common/storage/img2/light07_s.jpg"><img src="/resources/common/storage/img2/light07.jpg" alt="이미지"><em>opacity</em></a>
						<a href="/resources/common/storage/img2/light08_s.jpg"><img src="/resources/common/storage/img2/light08.jpg" alt="이미지"><em>saturate</em></a>
						<a href="/resources/common/storage/img2/light09_s.jpg"><img src="/resources/common/storage/img2/light09.jpg" alt="이미지"><em>sepia</em></a>
						<a href="/resources/common/storage/img2/light10_s.jpg"><img src="/resources/common/storage/img2/light10.jpg" alt="이미지"><em>Mix</em></a>
					</div>



                		<!-- <figure>
                		<iframe width="560" height="315" src="https://www.youtube.com/embed/d9IxdwEFk1c" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                		</figure> -->


                		<!--<figure>
                        	<img src="img/slider001.jpg">
                        	<figcaption><em>Responsive Site2</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span>
                        	</figcaption>
                        </figure> -->
                    </div>


                <!-- <div class="video">
                	<iframe  src="https://www.youtube.com/embed/Uvnru8qalXQ" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div> -->
			<!-- //video --> 
		</article>
			<!-- //col4 -->
	<!-- 	<article class="column col5">
		<h4 class="col_tit">Blend Effect</h4>
		<p class="col_desc">Background-blend-mode와 mix-blend-mode</p>
		lightbox
	                <div class=" lightbox square clearfix">
						<a href="https://www.youtube.com/embed/Uvnru8qalXQ"><img src="img/bibi.jpg" alt="이미지"><em>blur</em></a>
					<a href="https://www.youtube.com/watch?v=Uvnru8qalXQ"><img src="img/palette.jpg" alt="이미지"><em>brightness</em></a>
						<a href="img/light03_s.jpg"><img src="img/양다일_고백.jpg" alt="이미지"><em>contrast</em></a>
						<a href="img/light04_s.jpg"><img src="img/blueming.jpg" alt="이미지"><em>hur-rotate</em></a>
						<a href="img/light05_s.jpg"><img src="img/IU.jpg" alt="이미지"><em>grayscale</em></a>
						<a href="img/light06_s.jpg"><img src="img/zico.jpg" alt="이미지"><em>invert</em></a>
						<a href="img/light07_s.jpg"><img src="img/light07.jpg" alt="이미지"><em>opacity</em></a>
						<a href="img/light08_s.jpg"><img src="img/light08.jpg" alt="이미지"><em>saturate</em></a>
						<a href="img/light09_s.jpg"><img src="img/light09.jpg" alt="이미지"><em>sepia</em></a>
						<a href="img/light10_s.jpg"><img src="img/light10.jpg" alt="이미지"><em>Mix</em></a>
					</div>
		//lightbox 
	</article> -->
			<!-- //col5 -->

		<article class="column col6">
			<!-- <h4 class="col_tit">Video</h4>
			<p class="col_desc">반응형 영상을 보여주는 영역입니다.</p> -->
			<!-- video -->
                <!--  <video autoplay="autoplay" controls="controls" loop="loop">
                	<source src="img/blueming.mp4" type="video/mp4">
                </video> -->

                <h4 class="col_tit">Slick Slider</h4>
			<p class="col_desc">slick.js를 이용한 이미지 슬라이드 효과입니다.</p>
			<!-- 이미지 슬라이드 -->
                <div class="slider2">
                	<div>
                		   <div class="box2">
                            <div class="box1">
                            	<a href=""><img src="/resources/common/storage/img2/WildFlower.jpg"></a>
                            </div>
                              <div class="box1">
                            	
                            </div>
                               <div class="box1">
                            	
                            </div>
                            </div>

                            <div class="box2">
                             <div class="box1">
                            	
                            </div>
                             <div class="box1">
                            	
                            </div>
                             <div class="box1">
                            	
                            </div>


                            </div>

                              

                         <!-- <figure>
                		<iframe width="560" height="315" src="https://www.youtube.com/embed/nM0xDI5R50E" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                		</figure>
                		 -->
                        <!-- <figure>
                        	<img src="img/slider001.jpg">
                        	<figcaption><em>Responsive Site1</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span></figcaption>
                        </figure> -->
                	</div>
                	<div>
                		<figure>
                		<iframe width="560" height="315" src="https://www.youtube.com/embed/d9IxdwEFk1c" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                		</figure>
                		<!--<figure>
                        	<img src="img/slider001.jpg">
                        	<figcaption><em>Responsive Site2</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span>
                        	</figcaption>
                        </figure> -->
                    </div>
                	<div class="movie1">
                		<figure>
                        <iframe width="560" height="315" src="https://www.youtube.com/embed/Uvnru8qalXQ" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                        </figure>
                		<!--<figure>
                        	<img src="img/slider001.jpg">
                        	<figcaption><em>Responsive Site3</em><span>슬라이드 플러그인을 이용한 반응형 이미지 슬라이드</span></figcaption>
                        </figure>-->

                    </div>

                </div>


                <!-- <div class="video">
                	<iframe  src="https://www.youtube.com/embed/Uvnru8qalXQ" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div> -->
			<!-- //video --> 
		</article>
	</section>
	<section id="con_right">
		<h3 class="ir_su">반응형 사이트 오른쪽 컨텐츠</h3>
			<!-- //col6 -->
		<article class="column col7">
			
			<h4 class="col_tit">Music play</h4>
			<p class="col_desc">음악재생</p>
			<!-- side1 -->

               <div class="side1">
               	<figure class="front">
               		<div id="aplayer"></div>
               		<!-- <img src="img/side1.jpg" alt="이미지1"> -->
               	</figure>
               	<div class="back">
               		<i class="fa fa-heart" aria-hidden="true"></i>
               	</div>
               </div>
			<!-- //side1 --> 
		</article>
			<!-- //col7 -->
		<article class="column col8">
		<h4 class="col_tit">Effect2</h4>
			<p class="col_desc">CSS의 transform을 이용한 마우스 오버효과입니다.</p>
			<!-- side2 -->
               <div class="side2">
               	<figure class="front">
               		<img src="/resources/common/storage/img2/side4.jpg" alt="이미지2">
               		<figcaption>
               			Hover Effect
               		</figcaption>
               	</figure>
               	<figure class="back">
               		<img src="/resources/common/storage/img2/side2.jpg" alt="이미지2">
               		<figcaption>
               			Hover Effect
               		</figcaption>
               	</figure>
               </div>
			<!-- //side2 --> 
		</article>
			<!-- //col8 -->
		<article class="column col9">
			<h4 class="col_tit">Effect3</h4>
			<p class="col_desc">CSS의 transform 효과
			<!-- side3 -->
               <div class="side3">
               	<figure>
               		<img  src="/resources/common/storage/img2/side3.jpg" alt="이미지3">
               		<figcaption>
               			<h3>Hover<em>Effect</em></h3>
               		</figcaption>
               	</figure>
               </div>


                <div class="side3">
               	<figure>
               		<img  src="/resources/common/storage/img2/side3.jpg" alt="이미지3">
               		<figcaption>
               			<h3>Hover<em>Effect</em></h3>
               		</figcaption>
               	</figure>
               </div>
			<!-- //side3 --> 
		</article>
			<!-- //col9 -->
	</section>
	</div>
	

<!--//section-->
</main>

<footer id="footer">

        <div class="container">
            <div class="row">
                <div class="footer">
                    <ul>
                        <li><a href="#">사이트 도움말</a></li>
                        <li><a href="#">사이트 이용약관</a></li>
                        <li><a href="#">사이트 운영원칙</a></li>
                        <li><a href="#"><strong>개인정보취급방침</strong></a></li>
                        <li><a href="#">책임의 한계와 법적고지</a></li>
                        <li><a href="#">게시중단요청서비스</a></li>
                        <li><a href="#">고객센터</a></li>
                    </ul>
                    <address>
                        Copyright ©
                        <a href="http://webstoryboy.co.kr"><strong>webstoryboy</strong></a>
                        All Rights Reserved.

                    </address>
                </div>
            </div>
        </div>
         


    </footer>


  
    <!-- //footer -->

   <!-- JavaScript Libraries -->
    <script src="/resources/js/index/jquery.min_1.12.4.js"></script>
    <script src="/resources/js/index/modernizr-custom.js"></script>
     <script src="/resources/js/index/slick.min.js"></script>
     <script src="/resources/js/index/lightgallery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aplayer/1.10.1/APlayer.min.js"></script>

     <script>
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
    </script>





    
    	
    


</body>
</html>


</html>
