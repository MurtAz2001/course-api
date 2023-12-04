package com.murtaza.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring","spring Framework","Description spring"),
            new Topic("java","java Framework","Description java"),
            new Topic("javascript","javascript Framework","Description javascript")
    ));

    public List<Topic> getAllTopics(){
//        return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }
    public Optional<Topic> getTopic(String id){
//       return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
       return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
//        topics.add(topic);
        topicRepository.save(topic);
    }
    public Topic deleteTopic(String id) {
//        topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
        return null;
    }

    public void updateTopic(String id, Topic topic) {
//        for (int i =0; i< topics.size() ; i++){
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)){
//                topics.set(i,topic);
//                return;
//            }
//        }
        topicRepository.save(topic);
    }
}
