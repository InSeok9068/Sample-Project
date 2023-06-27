## 스펙

- Language : Java 17
- BackEnd Framework : Spring Boot
- Database Framework : JPA
- Caching : Redis | Caffeine
- Message Queue : Redis Queue | Spring Event
- Lock : Redis | JDBC(H2)
- Circuit Breaker : Resilience4j
- API Doc : Open API (http://localhost:8080/swagger-ui.html)

## 참고사항

### @Transactional, @Async, @Cacheable(다른 캐싱 관련 어노테이션 포함) [참고 URL](https://www.notion.so/Transactional-e8dcb4e3ab514ea4a3a196fce51ad4cc)

- 해당 어노테이션의 경우는 AOP 프록시 객체를 통해서 동작하기 때문에 내부 클래스에서 서로를 호출하면 정상적인 동작을 하지 않음 <br>
  ※ 피해갈 방법은 있지만 권장하진 않음 