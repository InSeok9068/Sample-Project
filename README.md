## 스펙

- Language : Java 17
- BackEnd Framework : Spring Boot
- Database Framework : JPA
- Caching : Redis(분산) | Caffeine(임베디드)
- Message Queue : Redis Queue(분산) | Spring Event(임베디드)
- Lock : Redis | JDBC(H2)
- Circuit Breaker : Resilience4j
- API Doc : Open API (http://localhost:8080/swagger-ui.html)

## 참고사항

### @Transactional, @Async, @Cacheable(다른 캐싱 관련 어노테이션 포함) [참고 URL](https://www.notion.so/Transactional-e8dcb4e3ab514ea4a3a196fce51ad4cc)

- 해당 어노테이션의 경우는 AOP 프록시 객체를 통해서 동작하기 때문에 내부 클래스에서 서로를 호출하면 정상적인 동작을 하지 않음 <br>
  ※ 피해갈 방법은 있지만 권장하진 않음

### @Nullable, @NonNull (org.springframework.lang)

- 해당 어노테이션을 사용하여 필드, 메서드 파라미터, 메서드 응닶값 Null 허용 및 불가를 표기
  - ※ @DefaultQualifier(value = NonNull.class, locations = TypeUseLocation.FIELD) 를 사용하여 클래스에 일괄 적용 가능