package WK.Lab.Service;

import WK.Lab.DTO.ContentDTO;
import WK.Lab.Entity.Content;
import WK.Lab.Entity.Portfolio;
import WK.Lab.Repository.ContentRepository;
import WK.Lab.Repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final ContentRepository contentRepository;
    private final PortfolioRepository portfolioRepository;

    //개인 포트폴리오 불러오기
    public ContentDTO viewPortfolio(Long uid){

        //세션에 저장된 uid로 포트폴리오 아이디인 pid 조회
        Portfolio portfolio = portfolioRepository.findByMember_Uid(uid);

        //조회한 pid로 포트폴리오 content 조회
        Content content = contentRepository.findByContentPortfolio_Pid(portfolio.getPid());

        //엔티티 -> DTO 메소드인 convert로 DTO에 값 세팅
        ContentDTO contentDTO = content.convert(content);

        return contentDTO;
    }

    //포트폴리오 저장 메소드
    public void savePortfolio(ContentDTO contentDTO, Long uid){

        //세션에 저장된 uid로 포트폴리오 아이디인 pid 조회
        Portfolio portfolio = portfolioRepository.findByMember_Uid(uid);

        //받아온 값 엔티티에 빌드
        Content content = new Content.Builder()
                .title(contentDTO.getTitle())
                .content(contentDTO.getContent())
                .tag(contentDTO.getTag())
                .contentPortfolio(portfolio)
                .build();

        //저장
        contentRepository.save(content);
    }

    //포트폴리오 수정 메소드
    public void updatePortfolio(ContentDTO contentDTO, Long uid){

        //세션에 저장된 uid로 포트폴리오 아이디 pid 조회
        Portfolio portfolio = portfolioRepository.findByMember_Uid(uid);

        //조회한 pid로 포트폴리오 content 조회
        Content content = contentRepository.findByContentPortfolio_Pid(portfolio.getPid());

        //수정 값 세팅 메소드인 updateContent를 이용해 DTO -> 엔티티 값 세팅
        content.updateContent(contentDTO);

    }


    //태그 검색
    public List<ContentDTO> searchTag(String tag){

        //포트폴리오 전체 조회
        List<Content> content = contentRepository.findAll();

        //결과 값 반환 용 ArrayList
        List<ContentDTO> result = new ArrayList<>();

        //전체 포트폴리오 수 만큼 포문 조회
        for(int i = 0; i < content.size(); i++){

            //i번째 콘텐트의 tag를 스플릿해서 배열에 저장
            String[] split = content.get(i).getTag().split(",");

            //스플릿 된 배열을 ArrayList로 변환
            List<String> splitTag = Arrays.stream(split).toList();

            //스플릿된 태그 ArrayList에 검색 요청 태그가 존재하면 결과 값 반환 용 리스트에 추가
            if(splitTag.contains(tag.trim())){

                result.add(content.get(i).convert(content.get(i)));

            }
        }

        return result;

    }

}
