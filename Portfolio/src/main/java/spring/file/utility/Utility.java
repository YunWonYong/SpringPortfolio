package spring.file.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//import spring.model.IReplyDAO;
//import spring.model.bbs.ReplyDAO;

public class Utility {

	public static List<String> getDay(){
        List<String> list = new ArrayList<String>();
        
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        for(int j = 0; j < 3; j++){
            list.add(sd.format(cal.getTime()));
            cal.add(Calendar.DATE, -1);
        }
        
        return list;
    }
	
	
    public static boolean compareDay(String wdate){
        boolean flag = false;
        List<String> list = getDay();
        if(wdate.equals(list.get(0)) 
           || wdate.equals(list.get(1))
           || wdate.equals(list.get(2))){
            flag = true;
        }
          
        return flag;
    }

	public static String checkNull(String str){
		if(str==null){
			str="";
		}
		
		return str;
	}
	  public static String paging1(int totalRecord, int nowPage, int recordPerPage, String col, String word){ 
	    int pagePerBlock = 10; // �뇡遺얠쑏?�뼣 ?�읂?�뵠筌�? ?�땾 
	    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // ?�읈筌�? ?�읂?�뵠筌�?  
	    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// ?�읈筌�? 域밸챶竊� 
	    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // ?�겱?�삺 域밸챶竊� 
	    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // ?�뱟?�젟 域밸챶竊�?�벥 ?�읂?�뵠筌�? 筌뤴뫖以� ?�뻻?�삂  
	    int endPage = (nowGrp * pagePerBlock);             // ?�뱟?�젟 域밸챶竊�?�벥 ?�읂?�뵠筌�? 筌뤴뫖以� �넫�굝利�   
	     
	    StringBuffer str = new StringBuffer(); 
	     
	    str.append("<DIV id='container'>"); 
//	    str.append("?�겱?�삺 ?�읂?�뵠筌�?: " + nowPage + " / " + totalPage + "  "); 
	    int _nowPage = (nowGrp-1) * pagePerBlock; // 10揶�? ?�뵠?�읈 ?�읂?�뵠筌�?嚥�? ?�뵠?猷� 
	    if (nowGrp >= 2){ 
	      str.append("<ul class='pager'><li><A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?�뵠?�읈</A></li></ul>"); 
	    } 
	 
	    for(int i=startPage; i<=endPage; i++){ 
	      if (i > totalPage){ 
	        break; 
	      } 
	  
	      if (nowPage == i){ 
	        str.append("<ul class='pagination'><li>"+i+"</li></ul>"); 
	      }else{ 
	        str.append("<ul class='pagination'><li><A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+i+"'>"+i+"</A></li></ul>");   
	      } 
	    } 
	    _nowPage = (nowGrp * pagePerBlock)+1; // 10揶�? ?�뼄?�벉 ?�읂?�뵠筌�?嚥�? ?�뵠?猷� 
	    if (nowGrp < totalGrp){ 
	      str.append("<ul class='pager'><li><A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?�뼄?�벉</A></li></ul>"); 
	    } 
	    str.append("</DIV>"); 
	     
	    return str.toString(); 
	  } 

	  public static String paging3(int totalRecord, int nowPage, int recordPerPage, String col, String word){ 
		    int pagePerBlock = 10; // �뇡遺얠쑏?�뼣 ?�읂?�뵠筌�? ?�땾 
		    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // ?�읈筌�? ?�읂?�뵠筌�?  
		    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// ?�읈筌�? 域밸챶竊� 
		    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // ?�겱?�삺 域밸챶竊� 
		    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // ?�뱟?�젟 域밸챶竊�?�벥 ?�읂?�뵠筌�? 筌뤴뫖以� ?�뻻?�삂  
		    int endPage = (nowGrp * pagePerBlock);             // ?�뱟?�젟 域밸챶竊�?�벥 ?�읂?�뵠筌�? 筌뤴뫖以� �넫�굝利�   
	     
		    StringBuffer str = new StringBuffer(); 
		     
		    str.append("<style type='text/css'>"); 
		    str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}"); 
		    str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}"); 
		    str.append("  #paging A:hover{text-decoration:none; background-color: #CCCCCC; color:black; font-size: 1em;}"); 
		    str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}"); 
		    str.append("  .span_box_1{"); 
		    str.append("    text-align: center;");    
		    str.append("    font-size: 1em;"); 
		    str.append("    border: 1px;"); 
		    str.append("    border-style: solid;"); 
		    str.append("    border-color: #cccccc;"); 
		    str.append("    padding:1px 6px 1px 6px; /*?�맄, ?�궎�몴紐꾠걹, ?釉�?�삋, ?�뇢筌�?*/"); 
		    str.append("    margin:1px 2px 1px 2px; /*?�맄, ?�궎�몴紐꾠걹, ?釉�?�삋, ?�뇢筌�?*/"); 
		    str.append("  }"); 
		    str.append("  .span_box_2{"); 
		    str.append("    text-align: center;");    
		    str.append("    background-color: #339999;"); 
		    str.append("    color: #FFFFFF;"); 
		    str.append("    font-size: 1em;"); 
		    str.append("    border: 1px;"); 
		    str.append("    border-style: solid;"); 
		    str.append("    border-color: #cccccc;"); 
		    str.append("    padding:1px 6px 1px 6px; /*?�맄, ?�궎�몴紐꾠걹, ?釉�?�삋, ?�뇢筌�?*/"); 
		    str.append("    margin:1px 2px 1px 2px; /*?�맄, ?�궎�몴紐꾠걹, ?釉�?�삋, ?�뇢筌�?*/"); 
		    str.append("  }"); 
		    str.append("</style>"); 
		    str.append("<DIV id='paging'>"); 
//		    str.append("?�겱?�삺 ?�읂?�뵠筌�?: " + nowPage + " / " + totalPage + "  "); 
		 
		    int _nowPage = (nowGrp-1) * pagePerBlock; // 10揶�? ?�뵠?�읈 ?�읂?�뵠筌�?嚥�? ?�뵠?猷� 
		    if (nowGrp >= 2){ 
		      str.append("<span class='span_box_1'><A href='./list?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?�뵠?�읈</A></span>"); 
		    } 
		 
		    for(int i=startPage; i<=endPage; i++){ 
		      if (i > totalPage){ 
		        break; 
		      } 
		  
		      if (nowPage == i){ 
		        str.append("<span class='span_box_2'>"+i+"</span>"); 
		      }else{ 
		        str.append("<span class='span_box_1'><A href='./list?col="+col+"&word="+word+"&nowPage="+i+"'>"+i+"</A></span>");   
		      } 
		    } 
		     
		    _nowPage = (nowGrp * pagePerBlock)+1; // 10揶�? ?�뼄?�벉 ?�읂?�뵠筌�?嚥�? ?�뵠?猷� 
		    if (nowGrp < totalGrp){ 
		      str.append("<span class='span_box_1'><A href='./list?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?�뼄?�벉</A></span>"); 

		    } 
		    str.append("</DIV>"); 
		     
		    return str.toString(); 
		  } 	 
	
	/** 
	   * ?�떭?�쁽 ?�굨?源�?�벥 ?�읂?�뵠筌�?, 1 ?�읂?�뵠筌�?�겫??苑� ?�뻻?�삂 
	   * ?�겱?�삺 ?�읂?�뵠筌�?: 11 / 22   [?�뵠?�읈] 11 12 13 14 15 16 17 18 19 20 [?�뼄?�벉] 
	   *  
	   * @param totalRecord ?�읈筌�? ?�쟿�굜遺얜굡?�땾 
	   * @param nowPage     ?�겱?�삺 ?�읂?�뵠筌�? 
	   * @param recordPerPage ?�읂?�뵠筌�??�뼣 �빊�뮆�젾?釉� ?�쟿�굜遺얜굡 ?�땾
	   * @param col 野�??源� �뚎됱쓥  
	   * @param word 野�??源�?堉�
	   * @return ?�읂?�뵠筌�? ?源�?苑� �눧紐꾩쁽?肉�
	   */ 
	  public static String paging(int totalRecord, int nowPage, int recordPerPage, String col, String word){ 
	    int pagePerBlock = 10; // �뇡遺얠쑏?�뼣 ?�읂?�뵠筌�? ?�땾 
	    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage));// ?�읈筌�? ?�읂?�뵠筌�?  
	    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// ?�읈筌�? 域밸챶竊� 
	    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // ?�겱?�삺 域밸챶竊� 
	    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // ?�뱟?�젟 域밸챶竊�?�벥 ?�읂?�뵠筌�? 筌뤴뫖以� ?�뻻?�삂  
	    int endPage = (nowGrp * pagePerBlock);             // ?�뱟?�젟 域밸챶竊�?�벥 ?�읂?�뵠筌�? 筌뤴뫖以� �넫�굝利�   
	     
	    StringBuffer str = new StringBuffer(); 
	     
	    str.append("<style type='text/css'>"); 
	    str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}"); 
	    str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}"); 
	    str.append("  #paging A:hover{text-decoration:underline; background-color: #ffffff; color:black; font-size: 1em;}"); 
	    str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}"); 
	    str.append("</style>"); 
	    str.append("<DIV id='paging'>"); 
	    str.append("�쁽�옱 �럹�씠吏� " + nowPage + " / " + totalPage + "  "); 
	 
	    int _nowPage = (nowGrp-1) * pagePerBlock; // 10揶�? ?�뵠?�읈 ?�읂?�뵠筌�?嚥�? ?�뵠?猷� 
	    if (nowGrp >= 2){ 
	      str.append("[<A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?�뵠?�읈</A>]"); 
	    } 
	 
	    for(int i=startPage; i<=endPage; i++){ 
	      if (i > totalPage){ 
	        break; 
	      } 
	  
       if (nowPage == i){ // ?�겱?�삺 ?�읂?�뵠筌�??�뵠筌�? 揶쏅벡�� ?�뒞��? 
	        str.append("<span style='font-size: 1.2em; font-weight: bold;'>"+i+"</span> ");   
	      }else{ 
	        str.append("<A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+i+"'>"+i+"</A> "); 
	      } 
	       
	    } 
	     
	    _nowPage = (nowGrp * pagePerBlock)+1; // 10揶�? ?�뼄?�벉 ?�읂?�뵠筌�?嚥�? ?�뵠?猷� 
	    if (nowGrp < totalGrp){ 
	      str.append("[<A href='./list.jsp?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?�뼄?�벉</A>]"); 

	    } 
	    str.append("</DIV>"); 
	     
	    return str.toString(); 
	  }
	public static String saveFile(MultipartFile fileMF, String basePath) {
		 // input form's parameter name 
        String fileName = ""; 
        // original file name 
        String originalFileName = fileMF.getOriginalFilename(); 
        // file content type 
        String contentType = fileMF.getContentType(); 
        // file size 
        long fileSize = fileMF.getSize(); 
         
        System.out.println("fileSize: " + fileSize); 
        System.out.println("originalFileName: " + originalFileName); 
         
        InputStream inputStream = null; 
        OutputStream outputStream = null; 
 
        try { 
            if( fileSize > 0 ) { // �뙆�씪�씠 議댁옱�븳�떎硫� 
                // �씤�뭼 �뒪�듃由쇱쓣 �뼸�뒗�떎. 
                inputStream = fileMF.getInputStream(); 
 
                File oldfile = new File(basePath, originalFileName); 
             
                if ( oldfile.exists()){ 
                    for(int k=0; true; k++){ 
                        //�뙆�씪紐� 以묐났�쓣 �뵾�븯湲� �쐞�븳 �씪�젴 踰덊샇瑜� �깮�꽦�븯�뿬 
                        //�뙆�씪紐낆쑝濡� 議고빀 
                        oldfile = new File(basePath,"("+k+")"+originalFileName); 
                     
                        //議고빀�맂 �뙆�씪紐낆씠 議댁옱�븯吏� �븡�뒗�떎硫�, �씪�젴踰덊샇媛� 
                        //遺숈� �뙆�씪紐� �떎�떆 �깮�꽦 
                        if(!oldfile.exists()){ //議댁옱�븯吏� �븡�뒗 寃쎌슦 
                            fileName = "("+k+")"+originalFileName; 
                            break; 
                        } 
                    } 
                }else{ 
                    fileName = originalFileName; 
                } 
                //make server full path to save 
                String serverFullPath = basePath + "\\" + fileName; 
                 
                System.out.println("fileName: " + fileName); 
                System.out.println("serverFullPath: " + serverFullPath); 
                 
                outputStream = new FileOutputStream( serverFullPath ); 
  
                // 踰꾪띁瑜� 留뚮뱺�떎. 
                int readBytes = 0; 
                byte[] buffer = new byte[8192]; 
 
                while((readBytes = inputStream.read(buffer, 0, 8192)) != -1 ) { 
                    outputStream.write( buffer, 0, readBytes ); 
                } 
                outputStream.close(); 
                inputStream.close(); 
                         
            } 
 
        } catch(Exception e) { 
            e.printStackTrace();   
        }finally{ 
             
        } 
         
        return fileName; 
	}
        public static void deleteFile(String upDir,String oldfile){
        	File file = new File(upDir,oldfile);
        	if(file.exists()){
        		file.delete();
        }
    }


/** 
 * �뙎湲��슜 �럹�씠吏� 硫붿냼�뱶
 * @param totalRecord �쟾泥� �젅肄붾뱶�닔 
 * @param nowPage     �뙎湲��쓽 �쁽�옱 �럹�씠吏� 
 * @param recordPerPage �뙎湲��쓽 �럹�씠吏��떦 �젅肄붾뱶 �닔 
 * @param url �씠�룞�븷 �럹�씠吏� - read
 * @param bbsno bbs 湲�踰덊샇
 * @param nowPage bbs�쓽 �쁽�옱 �럹�씠吏�
 * @param col bbs�쓽 寃��깋 而щ읆
 * @param word bbs�쓽 寃��깋�뼱
 * @return �럹�씠吏� �깮�꽦 臾몄옄�뿴
 */ 
public static String paging(String noname, int totalRecord, int nPage, int recordPerPage,String url,int bbsno,int nowPage, String col, String word){ 
  int pagePerBlock = 10; // 釉붾윮�떦 �럹�씠吏� �닔 
  int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // �쟾泥� �럹�씠吏�  
  int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// �쟾泥� 洹몃９ 
  int nowGrp = (int)(Math.ceil((double)nPage/pagePerBlock));    // �쁽�옱 洹몃９ 
  int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // �듅�젙 洹몃９�쓽 �럹�씠吏� 紐⑸줉 �떆�옉  
  int endPage = (nowGrp * pagePerBlock);             // �듅�젙 洹몃９�쓽 �럹�씠吏� 紐⑸줉 醫낅즺   
   
  StringBuffer str = new StringBuffer(); 
   
  str.append("<style type='text/css'>"); 
  str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}"); 
  str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}"); 
  str.append("  #paging A:hover{text-decoration:none; background-color: #CCCCCC; color:black; font-size: 1em;}"); 
  str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}"); 
  str.append("  .span_box_1{"); 
  str.append("    text-align: center;");    
  str.append("    font-size: 1em;"); 
  str.append("    border: 1px;"); 
  str.append("    border-style: solid;"); 
  str.append("    border-color: #cccccc;"); 
  str.append("    padding:1px 6px 1px 6px; /*�쐞, �삤瑜몄そ, �븘�옒, �쇊履�*/"); 
  str.append("    margin:1px 2px 1px 2px; /*�쐞, �삤瑜몄そ, �븘�옒, �쇊履�*/"); 

  str.append("  }"); 
  str.append("  .span_box_2{"); 
  str.append("    text-align: center;");    
  str.append("    background-color: #668db4;"); 
  str.append("    color: #FFFFFF;"); 
  str.append("    font-size: 1em;"); 
  str.append("    border: 1px;"); 
  str.append("    border-style: solid;"); 
  str.append("    border-color: #cccccc;"); 
  str.append("    padding:1px 6px 1px 6px; /*�쐞, �삤瑜몄そ, �븘�옒, �쇊履�*/"); 
  str.append("    margin:1px 2px 1px 2px; /*�쐞, �삤瑜몄そ, �븘�옒, �쇊履�*/"); 
  str.append("  }"); 
  str.append("</style>"); 
  str.append("<DIV id='paging'>"); 
//    str.append("�쁽�옱 �럹�씠吏�: " + nowPage + " / " + totalPage + "  "); 

  int _nowPage = (nowGrp-1) * pagePerBlock; // 10媛� �씠�쟾 �럹�씠吏�濡� �씠�룞 
  if (nowGrp >= 2){ 
    str.append("<span class='span_box_1'><A href='./"+url+"?nowPage="+nowPage+"&col="+col+"&word="+word+"&"+noname+"="+bbsno+"&nPage="+_nowPage+"'>�씠�쟾</A></span>"); 
  } 

  for(int i=startPage; i<=endPage; i++){ 
    if (i > totalPage){ 
      break; 
    } 

    if (nPage == i){ 
      str.append("<span class='span_box_2'>"+i+"</span>"); 
    }else{ 
      str.append("<span class='span_box_1'><A href='./"+url+"?nowPage="+nowPage+"&col="+col+"&word="+word+"&"+noname+"="+bbsno+"&nPage="+i+"'>"+i+"</A></span>");   
    } 
  } 
   
  _nowPage = (nowGrp * pagePerBlock)+1; // 10媛� �떎�쓬 �럹�씠吏�濡� �씠�룞 
  if (nowGrp < totalGrp){ 
    str.append("<span class='span_box_1'><A href='./"+url+"?nowPage="+nowPage+"&col="+col+"&word="+word+"&"+noname+"="+bbsno+"&nPage="+_nowPage+"'>�떎�쓬</A></span>"); 
  } 
  str.append("</DIV>"); 
   
  return str.toString(); 
} 

}