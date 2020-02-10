package com.crud.tasks.service;

import com.crud.tasks.controller.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    @Mock
    private TrelloClient trelloClient;

    @InjectMocks
    private TrelloService trelloService;

    @Test
    public void shouldFetchTrelloBoards() {
        //Given
        List<TrelloListDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListDto("1", "test_list", false));
        List<TrelloBoardDto> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoardDto("1", "test", trelloLists));
        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoards);

        //When
        List<TrelloBoardDto> boards = trelloService.fetchTrelloBoards();

        //Then
        Assert.assertEquals(1, boards.size());
        Assert.assertEquals(1, boards.get(0).getLists().size());
    }

    @Test
    public void shouldCreateTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "test desc", "1", "123");
        CreatedTrelloCardDto cardDto = new CreatedTrelloCardDto("2314", "test", "short_url");
        when(trelloClient.createNewCard(any())).thenReturn(cardDto);

        //When
        CreatedTrelloCardDto trelloCard = trelloService.createTrelloCard(trelloCardDto);

        //Then
        Assert.assertEquals("2314", trelloCard.getId());
        Assert.assertEquals("test", trelloCard.getName());
        Assert.assertEquals("short_url", trelloCard.getShortUrl());
    }
}
