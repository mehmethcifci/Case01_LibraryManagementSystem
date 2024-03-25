package com.Case01_LibraryManagement.repository;

import com.Case01_LibraryManagement.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
}
