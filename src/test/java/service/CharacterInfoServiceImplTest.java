package service;

import com.cdonderis.rickandmorty.model.dto.CharacterDTO;
import com.cdonderis.rickandmorty.service.CharacterInfoServiceImpl;
import com.cdonderis.rickandmorty.utils.DateFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CharacterInfoServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CharacterInfoServiceImpl characterInfoServiceImpl = new CharacterInfoServiceImpl();


    @Test
    public void findCharactersByNameTest() throws ParseException {
        List<String> episodes = new ArrayList<>();
        episodes.add("First Test Episode");
        episodes.add("Second Test Episode");
        episodes.add("Third Test Episode");

        CharacterDTO testCharacter = new CharacterDTO("Adjudicator Rick", episodes,
                DateFormatter.dateFormatString("December 2, 2013"));

        String characterResponseBody = "{\"info\":{\"count\":1,\"pages\":1,\"next\":null,\"prev\":null}," +
                "\"results\":[{\"id\":8,\"name\":\"Adjudicator Rick\",\"status\":\"Dead\",\"species\":\"Human\"," +
                "\"type\":\"\",\"gender\":\"Male\",\"origin\":{\"name\":\"unknown\",\"url\":\"\"}," +
                "\"location\":{\"name\":\"Citadel of Ricks\",\"url\":\"https://rickandmortyapi.com/api/location/3\"}," +
                "\"image\":\"https://rickandmortyapi.com/api/character/avatar/8.jpeg\"," +
                "\"episode\":[\"https://rickandmortyapi.com/api/episode/28\"]," +
                "\"url\":\"https://rickandmortyapi.com/api/character/8\"," +
                "\"created\":\"2017-11-04T20:03:34.737Z\"}]}";

        ResponseEntity<String> mockCharacterResponse = new ResponseEntity<>(characterResponseBody, HttpStatus.OK);

        String episodeResponseBody = "{\"id\":28,\"name\":\"The Ricklantis Mixup\",\"air_date\":\"September 10, 2017\",\"episode\":\"S03E07\",\"characters\":[\"https://rickandmortyapi.com/api/character/1\",\"https://rickandmortyapi.com/api/character/2\",\"https://rickandmortyapi.com/api/character/4\",\"https://rickandmortyapi.com/api/character/8\",\"https://rickandmortyapi.com/api/character/18\",\"https://rickandmortyapi.com/api/character/22\",\"https://rickandmortyapi.com/api/character/27\",\"https://rickandmortyapi.com/api/character/43\",\"https://rickandmortyapi.com/api/character/44\",\"https://rickandmortyapi.com/api/character/48\",\"https://rickandmortyapi.com/api/character/56\",\"https://rickandmortyapi.com/api/character/61\",\"https://rickandmortyapi.com/api/character/72\",\"https://rickandmortyapi.com/api/character/73\",\"https://rickandmortyapi.com/api/character/74\",\"https://rickandmortyapi.com/api/character/78\",\"https://rickandmortyapi.com/api/character/85\",\"https://rickandmortyapi.com/api/character/86\",\"https://rickandmortyapi.com/api/character/118\",\"https://rickandmortyapi.com/api/character/123\",\"https://rickandmortyapi.com/api/character/135\",\"https://rickandmortyapi.com/api/character/143\",\"https://rickandmortyapi.com/api/character/165\",\"https://rickandmortyapi.com/api/character/180\",\"https://rickandmortyapi.com/api/character/187\",\"https://rickandmortyapi.com/api/character/206\",\"https://rickandmortyapi.com/api/character/220\",\"https://rickandmortyapi.com/api/character/229\",\"https://rickandmortyapi.com/api/character/233\",\"https://rickandmortyapi.com/api/character/235\",\"https://rickandmortyapi.com/api/character/267\",\"https://rickandmortyapi.com/api/character/278\",\"https://rickandmortyapi.com/api/character/281\",\"https://rickandmortyapi.com/api/character/283\",\"https://rickandmortyapi.com/api/character/284\",\"https://rickandmortyapi.com/api/character/287\",\"https://rickandmortyapi.com/api/character/288\",\"https://rickandmortyapi.com/api/character/289\",\"https://rickandmortyapi.com/api/character/291\",\"https://rickandmortyapi.com/api/character/292\",\"https://rickandmortyapi.com/api/character/322\",\"https://rickandmortyapi.com/api/character/325\",\"https://rickandmortyapi.com/api/character/328\",\"https://rickandmortyapi.com/api/character/345\",\"https://rickandmortyapi.com/api/character/366\",\"https://rickandmortyapi.com/api/character/367\",\"https://rickandmortyapi.com/api/character/392\",\"https://rickandmortyapi.com/api/character/472\",\"https://rickandmortyapi.com/api/character/473\",\"https://rickandmortyapi.com/api/character/474\",\"https://rickandmortyapi.com/api/character/475\",\"https://rickandmortyapi.com/api/character/476\",\"https://rickandmortyapi.com/api/character/477\",\"https://rickandmortyapi.com/api/character/478\",\"https://rickandmortyapi.com/api/character/479\",\"https://rickandmortyapi.com/api/character/480\",\"https://rickandmortyapi.com/api/character/481\",\"https://rickandmortyapi.com/api/character/482\",\"https://rickandmortyapi.com/api/character/483\",\"https://rickandmortyapi.com/api/character/484\",\"https://rickandmortyapi.com/api/character/485\",\"https://rickandmortyapi.com/api/character/486\",\"https://rickandmortyapi.com/api/character/487\",\"https://rickandmortyapi.com/api/character/488\",\"https://rickandmortyapi.com/api/character/489\"],\"url\":\"https://rickandmortyapi.com/api/episode/28\",\"created\":\"2017-11-10T12:56:36.618Z\"}";

        ResponseEntity<String> mockEpisodeResponse = new ResponseEntity<>(episodeResponseBody, HttpStatus.OK);

        Mockito
                .when(restTemplate.exchange("https://rickandmortyapi.com/api/character/?name=Adjudicator Rick",
                        HttpMethod.GET, null, String.class))
                        .thenReturn(mockCharacterResponse);

        Mockito
                .when(restTemplate.exchange("https://rickandmortyapi.com/api/episode/28",
                        HttpMethod.GET, null, String.class))
                .thenReturn(mockEpisodeResponse);

        List<CharacterDTO> characters = characterInfoServiceImpl.findCharactersByName("Adjudicator Rick");

        Assertions.assertEquals(1, characters.size());
        Assertions.assertEquals(testCharacter.getName(),characters.get(0).getName());
    }
}
