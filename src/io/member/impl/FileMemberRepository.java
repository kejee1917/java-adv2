package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import javax.imageio.IIOException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/member-txt.dat";
    private static final String DELIMITER = ",";
    @Override
    public void add(Member member) {
        
        //try with resources 마무리 자원정리
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(member.getId() + DELIMITER + member.getName() + DELIMITER + member.getAge());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      
    }

    @Override
    public List<Member> findAll() {
        ArrayList<Member> members = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] memberData = line.split(DELIMITER);
                members.add(new Member(memberData[0], memberData[1], Integer.valueOf(memberData[2])));
            }
            return members;
        }catch (FileNotFoundException e) { //  파일 없는 경우에 대비
            return new ArrayList<>();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
