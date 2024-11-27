package umc.spring.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.member.Member;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}