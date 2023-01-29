package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        List<TrelloListDto> list1 = new ArrayList<>();
        list1.add(new TrelloListDto("1", "lista 1", true));
        list1.add(new TrelloListDto("2", "lista 2", false));
        list1.add(new TrelloListDto("3", "lista 3", true));

        List<TrelloListDto> list2 = new ArrayList<>();
        list2.add(new TrelloListDto("4", "lista 4", true));
        list2.add(new TrelloListDto("5", "lista 5", false));
        list2.add(new TrelloListDto("6", "lista 6", true));
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("123", "board 1", list1);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("124", "board 2", list2);

        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto1);
        trelloBoardDtoList.add(trelloBoardDto2);
        List<TrelloBoard> resultList = trelloMapper.mapToBoards(trelloBoardDtoList);

        assertEquals(2, resultList.size());
    }

    @Test
    public void testMapToBoardsDto() {
        List<TrelloList> list1 = new ArrayList<>();
        list1.add(new TrelloList("1", "lista 1", true));
        list1.add(new TrelloList("2", "lista 2", false));
        list1.add(new TrelloList("3", "lista 3", true));

        List<TrelloList> list2 = new ArrayList<>();
        list2.add(new TrelloList("4", "lista 4", true));
        list2.add(new TrelloList("5", "lista 5", false));
        list2.add(new TrelloList("6", "lista 6", true));
        TrelloBoard trelloBoard1 = new TrelloBoard("123", "board 1", list1);
        TrelloBoard trelloBoard2 = new TrelloBoard("124", "board 2", list2);

        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard1);
        trelloBoardList.add(trelloBoard2);
        List<TrelloBoardDto> resultList = trelloMapper.mapToBoardsDto(trelloBoardList);

        assertEquals(2, resultList.size());
    }

    @Test
    public void testMapToListDto() {
        List<TrelloList> list1 = new ArrayList<>();
        list1.add(new TrelloList("1", "lista 1", true));
        list1.add(new TrelloList("2", "lista 2", false));
        list1.add(new TrelloList("3", "lista 3", true));

        List<TrelloListDto> resultList = trelloMapper.mapToListDto(list1);

        assertEquals(3, resultList.size());
    }

    @Test
    public void testMapToList() {
        List<TrelloListDto> list1 = new ArrayList<>();
        list1.add(new TrelloListDto("1", "lista 1", true));
        list1.add(new TrelloListDto("2", "lista 2", false));
        list1.add(new TrelloListDto("3", "lista 3", true));

        List<TrelloList> resultList = trelloMapper.mapToList(list1);

        assertEquals(3, resultList.size());
    }

    @Test
    public void testMapToCardDto() {
        TrelloCard card = new TrelloCard("karta", "taka karta", "pos", "1");
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(card);

        assertEquals("karta", cardDto.getName());
    }

    @Test
    public void testMapTocard() {
        TrelloCardDto cardDto = new TrelloCardDto("karta", "taka karta", "pos", "1");
        TrelloCard card = trelloMapper.mapToCard(cardDto);

        assertEquals("1", card.getListId());
    }

}
