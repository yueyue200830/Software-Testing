package com.ecnu.timeline;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author Jiayi Zhu
 * @date 2019-10-14
 */
@RestController
@CrossOrigin(origins = "*")
public class Connector {
    @Autowired
    CommentRepository commentRepository;

    @PostMapping("onCreate")
    public String onCreate() {
        System.out.println("On create");

        List<Comment> all = commentRepository.findLatestComments(4);
        JSONObject jsonObject = new JSONObject();
        jsonObject.append("comments", all);

        return jsonObject.toString();
    }

    @RequestMapping(value = "loadMore", method = RequestMethod.POST)
    public String loadMore(@RequestBody String response) throws ParseException {
        System.out.println("Load more");

        JSONObject jsonObject = new JSONObject(response);
        SimpleDateFormat isoFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        Date time = isoFormat.parse(jsonObject.getString("time"));

        List<Comment> moreComments = commentRepository.findMoreCommentsBefore(time, 2);
        JSONObject returnObject = new JSONObject();
        returnObject.append("moreComments", moreComments);

        return returnObject.toString();
    }

    @PostMapping("refresh")
    public String refresh() {
        System.out.println("Refresh data");

        List<Comment> all = commentRepository.findLatestComments(4);

        JSONObject jsonObject = new JSONObject();
        jsonObject.append("comments", all);

        return jsonObject.toString();
    }
}
