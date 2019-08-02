<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>映画登録</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="css/masterMovieInsertListStyle.css">
</head>
<%
List<String> errorMsgs=(List<String>)request.getAttribute("errorMsgs");
%>
<body>

<!-- jspヘッダー場所 -->
<jsp:include page="./header/mastersHeader.jsp"/>

<div class="container center">
<p>上映開始時間はシアター毎に、上映時間+30分の間を開けるよう設定して下さい</p>
<p>同じシアター番号を設定しないで下さい</p>
<p>上映開始終了日 シアター番号一覧 上映開始時間帯 サムネイルは変更できないので正確に入力して下さい</p> 
<p>存在しない日付を入力しないで下さい</p>
<p>*必須</p>

<form action="regist_check" enctype="multipart/form-data" method="POST" name="form">
<table border="1">
<tr>
<th>映画の名前 * </th>
<td><input type="text" name="movie_name" class="MovieName"></td>
</tr>
<tr>
<th>説明文 *</th>
<td><textarea name="movie_description" class="MovieDescription" rows="4" cols="100%"></textarea>
</td>
</tr>
<tr><th>上映時間 *</th><td>
<select name="movie_time_hour">
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select>
時
<select name="movie_time_minute">
<option value="00">0</option>
<option value="10">10</option>
<option value="20">20</option>
<option value="30">30</option>
<option value="40">40</option>
<option value="50">50</option>
</select>分間</td>
</tr>
<tr>
<th>上映開始日終了日</th>
<td>

<select name="movie_time_startyear">
<option value="2019">2019</option>
<option value="2020">2020</option>
<option value="2021">2021</option>
<option value="2022">2022</option>
<option value="2023">2023</option>
<option value="2024">2024</option>
<option value="2025">2025</option>
</select>
年
<select name="movie_time_startmonth">
<option value="01">1</option>
<option value="02">2</option>
<option value="03">3</option>
<option value="04">4</option>
<option value="05">5</option>
<option value="06">6</option>
<option value="07">7</option>
<option value="08">8</option>
<option value="09">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
</select>
月
<select name="movie_time_startday">
<option value="01">1</option>
<option value="02">2</option>
<option value="03">3</option>
<option value="04">4</option>
<option value="05">5</option>
<option value="06">6</option>
<option value="07">7</option>
<option value="08">8</option>
<option value="09">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
<option value="27">27</option>
<option value="28">28</option>
<option value="29">29</option>
<option value="30">30</option>
<option value="31">31</option>
</select>
日～
<select name="movie_time_endyear">
<option value="2019">2019</option>
<option value="2020">2020</option>
<option value="2021">2021</option>
<option value="2022">2022</option>
<option value="2023">2023</option>
<option value="2024">2024</option>
<option value="2025">2025</option>
</select>
年
<select name="movie_time_endmonth">
<option value="01">1</option>
<option value="02">2</option>
<option value="03">3</option>
<option value="04">4</option>
<option value="05">5</option>
<option value="06">6</option>
<option value="07">7</option>
<option value="08">8</option>
<option value="09">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
</select>
月
<select name="movie_time_endday">
<option value="01">1</option>
<option value="02">2</option>
<option value="03">3</option>
<option value="04">4</option>
<option value="05">5</option>
<option value="06">6</option>
<option value="07">7</option>
<option value="08">8</option>
<option value="09">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
<option value="27">27</option>
<option value="28">28</option>
<option value="29">29</option>
<option value="30">30</option>
<option value="31">31</option>
</select>
日
</td>
</tr>
<tr>
<th>シアター番号一覧</th>
<td>
<div id="theaterAdd">
<div class="theaterList" id="theaterList[0]" data-theater-id="0">
第<select name="theater_number[0]" id="theater_number[0]" onchange="getValue(0)" data-theater-id="0" >
<option value="01">01</option>
<option value="02">02</option>
<option value="03">03</option>
<option value="04">04</option>
<option value="05">05</option>
<option value="06">06</option>
<option value="07">07</option>
<option value="08">08</option>
<option value="09">09</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
</select>
シアター
<button type="button" id="add" class="add">追加</button>
</div>
</div>

<div id="theaterTemplate"class="notDisp" data-theater-id="99999999">
第<select name="CloneTheater" id="theater_number"  >
<option value="01">01</option>
<option value="02">02</option>
<option value="03">03</option>
<option value="04">04</option>
<option value="05">05</option>
<option value="06">06</option>
<option value="07">07</option>
<option value="08">08</option>
<option value="09">09</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
</select>
シアター
<button name="removeButton" type="button" data-theater-id="1" >削除</button>
</div>
</td>
</tr>
<tr>
<th>上映開始時間帯</th>
<td>
<div id="theaterStart[0]" data-theater-id="0">
第<span class="theaNum" id="theaNum[0]"></span>シアター
<br>
<select name="theater_start_hour[0]" id="theater_hour[0]" data-theater-id="0" >
<option value="00">00</option>
<option value="01">01</option>
<option value="02">02</option>
<option value="03">03</option>
<option value="04">04</option>
<option value="05">05</option>
<option value="06">06</option>
<option value="07">07</option>
<option value="08">08</option>
<option value="09">09</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>

</select>
時
<select name="theater_start_minute[0]" id="theater_minute[0]" data-theater-id="0">
<option value="00">00</option>
<option value="05">05</option>
<option value="10">10</option>
<option value="15">15</option>
<option value="20">20</option>
<option value="25">25</option>
<option value="30">30</option>
<option value="35">35</option>
<option value="40">40</option>
<option value="45">45</option>
<option value="50">50</option>
<option value="55">55</option>
</select>
分
<button type="button" onclick="movieStartAdd(0);">追加</button>
<div id="movieStart[0]"></div>
</div>
<!-- 要素追加場所 -->
</td>
</tr>
<tr>
<th>HPアドレス</th>
<td><input type="text" name="movie_address" id="movie_address" class="MovieAddress">
<br>
<button type="button" onclick="showHPaddress();">開く</button></td>

</tr>
<tr>
<th>サムネイル *</th>
<td>
<div class="imgInput">
<input type="file" name="thumbnail" >
<br>
</div>
</td>
</tr>
 
</table>
<%if(errorMsgs!=null) {%>
<%for(int j=0;j<errorMsgs.size();j++){ %>
<%=errorMsgs.get(j) %><br>
<%} %>
<%} %>
<input type="submit" value="送信" onclick="getTheaterId();">
<div class="notDisp" id="data_id"><input type="text" name="tID" id="tID"></div>
</form>
<a href="masters_top">トップページに戻る</a>
</div>
<jsp:include page="./footer/mastersFooter.jsp"/>
<!-- javascript読み込み -->
<!-- <script type="text/javascript" src="js/footerFixed.js"></script> -->
<!-- jQuery読み込み -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- サムネイル画像表示スクリプト -->
<script>
$(function(){
    var setFileInput = $('.imgInput');
 
    setFileInput.each(function(){
        var selfFile = $(this),
        selfInput = $(this).find('input[type=file]');
 
        selfInput.change(function(){
            var file = $(this).prop('files')[0],
            fileRdr = new FileReader(),
            selfImg = selfFile.find('.imgView');
 
            if(!this.files.length){
                if(0 < selfImg.size()){
                    selfImg.remove();
                    return;
                }
            } else {
                if(file.type.match('image.*')){
                    if(!(0 < selfImg.size())){
                        selfFile.append('<img alt="" class="imgView">');
                    }
                    var prevElm = selfFile.find('.imgView');
                    fileRdr.onload = function() {
                        prevElm.attr('src', fileRdr.result);
                    }
                    fileRdr.readAsDataURL(file);
                } else {
                    if(0 < selfImg.size()){
                        selfImg.remove();
                        return;
                    }
                }
            }
        });
    });
    //シアター番号追加
    var idNo=1;
    
	$('button#add').on('click',function(){
        $('div#theaterTemplate')
            // コピー処理
            .clone(true)
            // 不要なID削除
            .removeAttr("id")
            //シアター番号の枠組みにdata-theater-id追加
            .attr("data-theater-id",idNo)
            // 非表示解除
            .removeClass("notDisp")
            //<div class="theaterList" id="theaterList[0]" data-theater-id="0"></div>
            
            // テキストボックスのID追加
            .find("select[name=CloneTheater]")
            .attr("id", "theater_number["+idNo+"]")
            .attr("name","theater_number["+idNo+"]")
            .attr("data-theater-id",idNo)
            .attr("onchange","getValue("+idNo+")")
            .end()
            .find("button[name=removeButton]")
            .attr("data-theater-id",idNo)
            .end()
            .appendTo("div#theaterAdd");
        
        //映画上映開始シアター追加
        var idNoP=idNo-1;
        var THS='第<span class="theaNum" id="theaNum['+idNo+']"></span>シアター<br><select name="theater_start_hour['+idNo+']" id="theater_hour['+idNo+']" data-theater-id="'+idNo+'" ><option value="00">00</option><option value="01">01</option><option value="02">02</option><option value="03">03</option><option value="04">04</option><option value="05">05</option><option value="06">06</option><option value="07">07</option><option value="08">08</option><option value="09">09</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option></select> 時 <select name="theater_start_minute['+idNo+']" id="theater_minute['+idNo+']" data-theater-id="'+idNo+'"><option value="00">00</option><option value="05">05</option><option value="10">10</option><option value="15">15</option><option value="20">20</option><option value="25">25</option><option value="30">30</option><option value="35">35</option><option value="40">40</option><option value="45">45</option><option value="50">50</option><option value="55">55</option></select> 分 <button type="button" onclick="movieStartAdd('+idNo+');" > 追加 </button><div id="movieStart['+idNo+']"></div>';
        var theaterDivAdd='<div id="theaterStart['+idNo+']" data-theater-id='+idNo+'></div>';
        
        var mS = document.getElementById('theaterStart['+idNoP+']')
        mS.insertAdjacentHTML('afterend',theaterDivAdd);
        document.getElementById("theaterStart["+idNo+"]").innerHTML=THS;
        getValue(idNo);
    	// ID番号加算
        idNo++;
        $('')
    });
	
	
	
	// 削除ボタン押下時イベント
    $('button[name=removeButton]').on('click',function(){
    	var dataId=(this).getAttribute('data-theater-id');
        $(this).parent('div').remove();
        
        
        
        var elemTest = document.getElementById("theaterStart["+dataId+"]");
        
        elemTest.parentNode.removeChild(elemTest);
       
        var ulElement=document.getElementById("theaterAdd");
        var lastElementChild = ulElement.lastElementChild;
        var lastDataId=lastElementChild.getAttribute('data-theater-id');
        
        idNo=parseInt(lastDataId)+1;
    });
    

});

//シアター番号追加時映画上映時間シアター番号に即反映、映画上映開始にフォーム複製
function getValue( sId ){
	//シアター番号選択時即反映
    var a=document.getElementById('theater_number['+sId+']');
    
    document.getElementById("theaNum["+sId+"]").innerHTML=a.value;
}

//映画上映開始追加
function movieStartAdd(dataId){
	
	//alert(dataId);
    var DSE = document.createElement("div");
    DSE.innerHTML = '<div id="Theater_Start['+dataId+']"  data-theater-id="'+dataId+'"><select name="theater_start_hour['+dataId+']" id="theater_hour['+dataId+']" data-theater-id="'+dataId+'"><option value="00">00</option><option value="01">01</option><option value="02">02</option><option value="03">03</option><option value="04">04</option><option value="05">05</option><option value="06">06</option><option value="07">07</option><option value="08">08</option><option value="09">09</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option></select> 時 <select name="theater_start_minute['+dataId+']" id="theater_minute['+dataId+']" data-theater-id="'+dataId+'"><option value="00">00</option><option value="05">05</option><option value="10">10</option><option value="15">15</option><option value="20">20</option><option value="25">25</option><option value="30">30</option><option value="35">35</option><option value="40">40</option><option value="45">45</option><option value="50">50</option><option value="55">55</option></select> 分 <button type="button"  name="movieStartDelete" onclick="movieSD('+dataId+');" > 削除</button></div>';
    var MSO = document.getElementById("movieStart["+dataId+"]");
    MSO.appendChild(DSE);
}
//映画上映開始削除
function movieSD(dataId){
	var eleTest = document.getElementById("Theater_Start["+dataId+"]");
    eleTest.parentNode.removeChild(eleTest);
}
//ホームページアドレスを別タブで表示
function showHPaddress(){
	var address=document.getElementById('movie_address');
	window.open(address.value,'_brank')
}
//ロード時シアター番号を上映開始時間帯に反映する
$(function() {
	
	var a = $('[name=theater_number\\[0\\]] option:selected').text();
	var b = $(".theaNum");
	b.text(a);
});
//theater-idをサーブレットに入れるため、valueを隠れテキストボックスにセット
function getTheaterId(){
	var ary=$("#theaterAdd");
	var children = ary.children();
	var dataId=[];
	for(var n=0;n<children.length;n++){
		var child = children[n];
		var d = child.getAttribute('data-theater-id');
		dataId.push(d);
	}
	var str=dataId.join(',');
	document.getElementById("tID").value=str;
}
</script>

</body>
</html>