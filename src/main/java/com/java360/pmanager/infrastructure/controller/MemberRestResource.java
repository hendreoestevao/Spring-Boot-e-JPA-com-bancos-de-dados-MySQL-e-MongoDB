package com.java360.pmanager.infrastructure.controller;

import com.java360.pmanager.domain.applicationservice.MemberService;
import com.java360.pmanager.domain.entity.Member;
import com.java360.pmanager.infrastructure.dto.MemberDTO;
import com.java360.pmanager.infrastructure.dto.SaveMemberDataDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.java360.pmanager.infrastructure.controller.RestConstants.PATH_MEMBERS;


@RequiredArgsConstructor
@RestController
@RequestMapping(PATH_MEMBERS)
public class MemberRestResource {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberDTO> addMember(@RequestBody @Valid SaveMemberDataDTO saveMemberData) {
        Member member = memberService.createMember(saveMemberData);
        return ResponseEntity.created(URI.create(PATH_MEMBERS + "/" + member.getId()))
                .body(MemberDTO.create(member));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> loadMemberById(@PathVariable("id") String memberId) {
        Member member = memberService.loadMemberById(memberId);
        return ResponseEntity.ok(MemberDTO.create(member));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable("id") String memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable("id") String memberId, @RequestBody @Valid SaveMemberDataDTO saveMemberData) {
        Member member = memberService.updateMember(memberId, saveMemberData);
        return ResponseEntity.ok(MemberDTO.create(member));
    }
}
