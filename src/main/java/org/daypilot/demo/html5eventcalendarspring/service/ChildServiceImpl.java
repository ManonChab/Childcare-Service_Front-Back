// package org.daypilot.demo.html5eventcalendarspring.service;

// import org.daypilot.demo.html5eventcalendarspring.Entity.Child;
// import org.daypilot.demo.html5eventcalendarspring.repository.ChildRepository;
// import org.springframework.stereotype.Service;

// @Service
// public class ChildServiceImpl implements ChildService{

//     private final ChildRepository childRepository;

//     public ChildServiceImpl(ChildRepository childRepository){
//         this.childRepository = childRepository;
//     }


//     @Override
//     public Child createChild(Child child) {
//         return childRepository.save(child);
//     }

//     @Override 
//     public Child getChildById(int id) {
//         return childRepository.findById(id)
//         .orElseThrow(() -> new RuntimeException("The child does not exist"));
//     }

//     @Override
//     public void updateChild(int id, Child child) {
//         Child updatedChild = getChildById(id);
//         childRepository.save(updatedChild);
//     }

//     @Override
//     public void deleteChild(int id) {
//         Child child = getChildById(id);
//         childRepository.delete(child);
//     }
// }
