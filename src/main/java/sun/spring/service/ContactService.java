package sun.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.spring.dao.ContactDAO;
import sun.spring.dto.ContactDTO;

@Service
public class ContactService {
	
	@Autowired
	ContactDAO cdao = new ContactDAO();
	
	public int conInsert(ContactDTO conDTO) throws Exception{
		int num = cdao.conInsert(conDTO);
		if(num == 1) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		return num;
	}
	
	/*게시판 네비게이션*/
	/* 총 게시물 갯수 */
	public List<ContactDTO> allBoardCount() throws Exception{
		int listCnt = cdao.allBoardCount();
		return cdao.conselect();
	}
	
	/* 게시물 10개씩 출력 */
	public List<ContactDTO> count10(int cpage) throws Exception{
		int innerBoradCount = 10; // 한 페이징 안에 들어가는 게시글 갯수
		int start = 0; //시작 값
		int end = 0;//마지막 값
		
		//총 게시물 갯수
		int allCount = cdao.allBoardCount();

		//페이지 별 게시글 start와 end값 지정
		if(cpage == 1) {
			start = cpage;
			end = cpage * innerBoradCount;
		}else {
			start = (cpage-1) * innerBoradCount + 1;  //2페이지 11페이지
			end = start + (innerBoradCount-1); //11+10 = 21
		}
		
		//하단 네비게이션이 디비 데이터가 몇개 들어가 있는지.
		int totalpage = allCount / innerBoradCount;
		totalpage = (allCount % innerBoradCount) > 0 ? totalpage+1 : totalpage;
		
		//하단 네비게이션 < > 기준점
		int startNav = (cpage-1) / innerBoradCount * innerBoradCount + 1;
		int endNav = 0;
		//TODO:: 페이징 고장남 .. 확인 부탁
		endNav = startNav + innerBoradCount - 1; // 이게 원본
		
		//페이지 네비게이션
		StringBuilder sd = new StringBuilder();
		if(startNav >= innerBoradCount) {
			sd.append("<a href = '/sub/contact/listProc?cpage="+(startNav-1)+"'> < </a>");
		}
		for (int i = startNav; i <= endNav; i++) {
			sd.append("<a href = '/sub/contact/listProc?cpage="+i+"'>"+i+"</a>");
			if(endNav > totalpage) {
				break;
			}
		}
		if(endNav <= totalpage) {
			sd.append("<a href = '/sub/contact/listProc?cpage="+(endNav+1)+"'> > </a>");
		}
		
		return cdao.boardCount10(start, end, sd);
	}
		
	public ContactDTO conView(ContactDTO conDTO) throws Exception{
		return cdao.conView(conDTO);
	}
	
	public int conDelete(ContactDTO conDTO) throws Exception{
		return cdao.conDelete(conDTO);
	}
	
	public int conModify(ContactDTO conDTO) throws Exception{
		return cdao.conModify(conDTO);
	}
}
