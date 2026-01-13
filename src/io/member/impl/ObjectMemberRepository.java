package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/member-object.dat";

    @Override
    public void add(Member member) {
        List<Member> members = findAll();
        members.add(member);

        //try with resources 마무리 자원정리
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH, true))) {
            oos.writeObject(members); // 컬렉션을 통으로 넣음
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object findObject = ois.readObject();
            return (List<Member>) findObject;
        }catch (FileNotFoundException e) { //  파일 없는 경우에 대비
            return new ArrayList<>();
            //여기서는 List.Of() 로 하면 안됨. 불변이기 때문에 추가가 안되니..!
        }catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
