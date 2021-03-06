# Spring Validation Module

**Member, MemberRequestDto, MemberResponseDto 3개의 클래스 생성**<br>
* 회원 정보를 나타내기 위해 Member 클래스만 사용하지 않은 이유는,
 Entity 클래스를 파라미터 혹은 View 데이터로 사용하게 되면 변화에 대응하기 힘들기 때문입니다.
* 휴대폰 번호 같은 경우 테이블에 저장되는 형태는 3개의 Column 으로 저장되는데, 화면에 입력 받는 형태는 하나의 문자열입니다.
* 이걸 Entity 로 구현하려면 Entity 클래스는 테이블의 역할을 벗어나 많은 **책임**을 담당하게 되고,
 **파라미터가 변경될 때마다 메인이 되는 Entity 클래스의 구조가 계속해서 변경**되게 됩니다.
 
반면에 **MemberRequestDto** 가 화면에서 입력 받는 파라미터 타입의 역할을 하게 될 경우,
 파라미터 형태가 변경되어도 **MemberRequestDto** 만 변경하면 되고 Entity 클래스는 변경하지 않아도 되기 때문에 테이블 구조가 변경될 일은 없습니다.<br>
* 추가적으로 Entity 클래스에 validation 어노테이션까지 포함되어 있으면 코드 자체가 너무 지저분해지는데,
 분리하게 될 경우 깔끔하게 코드가 작성될 수 있습니다.
* 동일한 이유로 View 에 출력되는 타입 역시 Entity 가 아닌 Response 클래스를 별도로 두어 어떤 출력 형태라도
 큰 변경없이 대응할 수 있도록 합니다.