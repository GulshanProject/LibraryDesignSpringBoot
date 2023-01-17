package com.example.LMSbackend.Service;


import com.example.LMSbackend.Enums.CardStatus;
import com.example.LMSbackend.Models.Card;
import com.example.LMSbackend.Models.Student;
import com.example.LMSbackend.Repository.StudentRepository;
import com.example.LMSbackend.RequestDto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CardService cardService;

    public String createStudent(StudentRequestDto studentRequestDto){
                       Student student= new Student();
                       student.setAge(studentRequestDto.getAge());
                       student.setCountry(studentRequestDto.getCountry());
                       student.setEmail(studentRequestDto.getEmail());
                       student.setName(studentRequestDto.getName());

        Card newCard= new Card();
        newCard.setCardStatus(CardStatus.ACTIVATED);
        newCard.setStudent(student);

        student.setCard(newCard);
        studentRepository.save(student);

              return "Successfully added student and card";
    }
}
