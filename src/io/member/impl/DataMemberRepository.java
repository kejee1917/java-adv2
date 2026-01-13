package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DataMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/member-data.dat";

    @Override
    public void add(Member member) {
        //try with resources 마무리 자원정리
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_PATH, true))) {
            dos.writeUTF(member.getId());
            dos.writeUTF(member.getName());
            dos.writeInt(member.getAge());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        ArrayList<Member> members = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_PATH))) {
            while (dis.available() > 0) {
                Member member = new Member(dis.readUTF(), dis.readUTF(), dis.readInt());
                members.add(member);
            }

            return members;
        }catch (FileNotFoundException e) { //  파일 없는 경우에 대비
            return new ArrayList<>();
            //List.Of() 가 더 좋음!
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
