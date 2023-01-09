package com.youcode.mypet.Controller;

import com.youcode.mypet.DTO.ReplyDTO;
import com.youcode.mypet.Request.ReplyRequest;
import com.youcode.mypet.Service.ReplyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @PostMapping("/reply/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@PathVariable String id, @RequestBody @Valid ReplyRequest replyRequest) throws Exception {
        replyService.createReply(replyRequest, Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/replies/{id}")
    public void delete(@PathVariable String id) throws Exception {
        replyService.deleteReply(Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/replies/{id}")
    public void update(@PathVariable String id, @RequestBody @Valid ReplyRequest replyRequest) throws Exception {
        replyService.updateReply(Long.parseLong(id), replyRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/replies/{id}")
    public ReplyDTO getOne(@PathVariable String id) throws Exception {
        return replyService.getOneReply(Long.parseLong(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/replies")
    public List<ReplyDTO> getAll(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "8") int limit) {
        return replyService.getAllReplies(page, limit);
    }
}