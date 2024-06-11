
# NCA 공부

1. 서버 생성시 init script를 통해 서버를 구성할 수 있다. CentOS 7.x 버전의 서버를 생성하면서 HTTPD를 설치한 후, HTTPD가 자동으로 가동되도록 init Script에 명령어를 입력하고자 하는 경우 올바른 명령어는 무엇인가
    - Systemctl enable httpd

2. 백업 상품 신청서 작성 시 필요한 정보
    - 백업 받을 서버의 호스트명
    - 백업 받을 서버의 비공인 IP
    - 데이터 사이즈

3. VPC 환경 / Classic 2세대 서버의 Standard 서버 스펙 중 생성 가능한 서버 스펙은 ?
     - vCPU 2개, RAM 8GB

4. 서버 패스워드에 대한 설명
    - 초기 패스워드는 서버 생성 시 생서한 인증키를 가지고 확인 할 수 있다.
    - 서버 생성 시 생성한 인증키는 다른 인증키로 교체할 수 있다.
    - 서버 초기 패스워드는 복잡한 문자열로 부여한다.

5. SSD 스토리지의 크기가 400GB일 때 MAX IOPS는 얼마인가.
    - 16000

6. VPC 환경 / Classic 2세대 서버의 Hight Memory 서버 스펙 중 생성 가능한 서버 스펙은 무엇인가.
    - vCPU 16개, RAM 128GB

7. 서버 생성 시 선택 가능한 스토리지 종류에 대한 설명 
    - SSD 타입은 저장장치가 SSD인 디스크이다.
    - 서버 타입에 따라 NVMe 디스크를 사용할 수 있다. 
    - SSD 타입은 MAS IOPS가 지정된다.

8. VPC 환경 / Classic 2세대 서버의 High CPU 스펙 중 생성 가능한 서버 스펙은?
    - vCPU 4개, RAM 8GB

9. VPC 환경에서 사용 중인 VM에 ACG 관리 작업으로 맞는 것을 고르시오 
    - ACG는 서버 NIC에 매핑된다.

10. Linux 용 init Script로 생성 가능한 스크립트 언어
    - bash
    - perl
    - python

11. Bare-Metal 서버 기능 설명으로 맞는 것은 ?
     - 운영체재로 Oracle Linux를 지원한다.

12. Object Storage에 대한 설명 
     - 파일 단위의 데이터 저장, 공유 , 배포가 가능하여 콘테츠를 저장하고, 다른 사용자에게 공유하거나 배포할 수 있다.
     - 대용량 데이터의 저장소로 활용할 수 있다.
     - CDN상품과 연동하여 사용할 수 있다.

13. 서버 스토리지에 대한 설명으로 맞는 것
    - 디스크의 사이즈를 기존보다 크게만 변경이 가능하다.

14. 백업 서비스 설명 
    -  보관 주기는 백업 주기의 최소 2배 이상이 되어야한다.
    - 증분 백업은 전체 백업 이후 백업 디렉토리 내 변경된 데이터만 백업하는 방식이다.
    - 전체 백업은 백업 디렉토리의 모든 데이터를 백업한다.

15. Networking 카테고리 상품
     - IPSec VPN
     - Load Balancer
     - NAT GateWay

16. VPC에서 사용할 수 있는 IP 대역
     - 10.0.0.0/16
     - 192.168.0.0/24
     - 192.168.0.0/16
     - 172.16.0.0/16

17. Classic 환경에서 서버에 부착된 하나의 NIC에 두개 이상의 IP를 부여하였을 때 발생할 수 있는 상황은?
    - 추가된 IP 뿐만 아니라 기존 IP도 통신이 되지 않는다.

18. VOD Transcoder에 대한 설명 
    - Preser은 1~5까지 설정 가능하다.
    - Codec는 H.264만 지원한다.
    - Output 경로는 File Storage와 Object Storage에 저장할 수 있다.

19. VPC 환경에서는 다양한 방식의 로드 밸런서를 제공하고 있다. 네이버 클라우드 플랫폼에서 제공하는 로드밸런서 방식은?
    - 애플리케이션 로드 밸런서
    - 네트워크 로드 밸런서
    - 네트워크 프록시 로드 밸런서

20. CDN+ 설명
    - CDN+는 HTTP/HTTPS 프로토콜을 통해 다양한 원본 서버와의 콘텐츠 연동을 지원한다.
    - 원본 서버로 고객이 보유 중인 다양한 웹서버 및 네이버 클라우드 플랫폼의 Storage, Server를 선택할 수 있다.
    - 레퍼러로 등록된 도메인 기준 접근 허용 기능을 제공한다.

21. 네트워크 로드밸런서의 특징
    - 별도의 설정 없이 Client IP 확인 가능
    - 분배 알고리즘은 Source IP Hash와 Round Robin 방식만 제공
    - HTTP,HTTPS 프로토콜을 지원하지 않는다.

22. VPC 환경에서 서버를 한 대 생성하였을 경우 Network Interface에 대한 설명
     - 서버 Network Interface는 최대 3개까지만 만들 수 있다.

23. Classic 환경의 로드밸런서와 유사한 VPC환경에서의 로드 밸런서는?
    - 네트워크 포록시 로드밸런서

24. 하나의 VPC에 ACG를 최대 몇개 까지 생성가능한가
    - 500개

25. VPC 환경에서 ACG에 대한 설명
    - 서버와 연결되어 있는 맵핑 정보를 변경할 수 있다.
    - VPC에 의존적이다.
    - White List 방식의 방화벽이다.

26. VPC환경의 로드밸런서 상품 설명
    - 22번 포트도 로드밸런싱할 수 있다.
    - VPC 환경에서는 3가지의 로드밸런서가 제공된다.
    - 부하처리 성능에 따라 Samll/Medium/large 중 스펙을 선택할 수 있다.

27. 라이브 스트리밍 서비스를 진행하는데 필요한 모든 Back-end 기능을 지원하며, Naver Cloud Platform CDN 연동을 통해 원활한 라이브 진행할 수 있는 상품은?
    - Live Station

28. CDN+ 관련 용어 설명
    - 서비스 도메인 : 서비스에서 콘텐츠 전송 시 사용자에게 노출되는 도메인
    - Ignore Query String : CDN 서비스가 원본 서버에 요청할 때 "?id=1234"와 같이 URL에 포함된 GET 파라미터를 제거한 후 에 요청
    - Referrer Domain : 콘텐츠가 지정된 도메인에만 제공되게 하여 다른 사이트에서 참되는 것을 방지한다.

29. 비고인 IP를 가진 다수의 서버에게 대표 공인 IP를 이용하여 외부 접속이 가능하게 해주는 상품은
    - NAT Gateway

30. VPC는 하나의 독립된 네트웍을 구성하게 된다 VPC를 다수 생성하게 되면 VPC간 통신은 되지 않는데 VPC간 통신을 가능하게 해주는 서비스는?
    - VPC Peering

31. NAS에 대한 설명
    - 볼륨은 최소 500GB 에서 최대 10TB까지이다.
    - 볼륨 크기에 따라 IOPS가 달라진다.
    - 볼륨 개수는 계정 당 20개로 제한된다.

32. 오브젝트 스토리지
    - 파일에 대한 공개 여부는 개별 파일에서 설정

33. 클라우드 비용과 관련이 가장 높은 개념
    - OPEX(운영 비용)

34. Cloud DB 상품에서 제공하는 DBMS
    - MS-SQL
    - MySQL
    - Redis

35. 네이버 플랫폼 보안 상품
    - App Safer
    - File Safer
    - Site Safer

36. GPU 상품에 대한 설명
    - 서버를 정지시켜도 요금이 발생
    - Linux OS를 지원한다.
    - T4, V100등의 GPU카드가 제공된다.

37. 오브젝트 스토리지 설명
    - 버킷 공개하기는 버킷 안의 폴더 ㅁ치 파일 정보 조회 및 업로드가 가능하다.
    - 버킷 권한은 목록 조회, 업로드, ACL조회, ACL수정이 가능하다.
    - 파일 권한은 다운로드, ACL조회, ACL수정이 가능하다.

38. VPC 환경에서 제공되는 GPU서버의 특징
    - NVDIA T4, V100 이용이 가능하다.
    -  서버 1대당 꽂을 수 있는 V100의 최대 개수는 4개이다.
    - Grid 기술을 사용 가능

39. NAS 상품 설명 
    - 자체 스냅샷 기능이 제공된다.
    - Linux Server와 Windows Server 모두 NAS를 마운트 할 수 있다.
    - NAS 볼륨은 네이버 클라우드 플랫폼 인프라 내에 있는 서버에서만 마운트 가능하다.

40.  Global Route Manager의 로드 밸런싱 타입
    - Weighted
    - Round Robin
    - Geolocation

41. 서버 이미지에 대한 설명
    - 서버 이미지가 생성되는 동안 서버는 일시적으로 '복제중' 상태이나 서버는 정상적으로 운영된다.
    - 서버 이미지를 다른 리전으로 복제할 수 있다.
    - 서버 이미지는 오토 스케일링의 Launch Configuration에서도 이용 가능
    
42. MC(Main Console)에서 설정 가능한 상품
    - Hybrid Cloud Hosting
    - Workplace

43. 국내 서비스로 한국 대상으올 대용량 파일 다운로드 할 때 적절한 상품 
    - CDN+

44. Live Migragtion
    -  Live Migration 이란 서버가 죽지 않고 호스트 서버가 변경 되는것을 뜻한다.

45. MC(Main Console) Dashboard에서 기본적으로 보여지는 내용
    - Daily Event
    - 결제 정보
    - CPU Top5

46. 카테고리가 같은 상품    
    - Effective Log Search & Analytics
    - Real User Analytics
    - Cloud Hadoop

47. 서비스로의 인프라를 의미 하고 일반적으로 Computing, Networking, Storage등의 IT 리소스 서비스 형태
     - laas

48. CLI 사용 올바른 방법
    - CLI 참조서에서 CLI파일을 다운로드 하여 서버에 설치한다.

49.  쿠버네티스 워커 노드에 설치 되있는 요소
    - docker
    - kublet
    - kube-proxy

50. NAS 볼륨 스냅샷에 대한 설명
    - NAS 볼륨 가용량 안에서 성생
    - 볼륨 사용량에 대한 모니터링이 가능

51. RAID 1+0 설명
    - RAID1으로 구성된 볼륨을 RAIDO으로 구성한다.
    - 저장공간 손실이 50%이다
    - 단순 볼륨에 비해 읽기 쓰기 속도가 뛰어나다.

52. Kubernetes에서 service 객체를 통해 만들어지는 로드 밸런서 타입은?
    - Network LB

53. File System의 데이터 저장 방식 중 데이터 저장공간의 비효율성이 존재하는 방식
    - 분산 저장 방식

54. 오토 스케일링 
    - 네이버 클라우드 플랫폼 CLI로 제어할 수 있다.
    - 스케일 인 대상 VM에 대한 사용자 지정이 가능하다.

55. Live Migration 지원 서버타입
    - Standard
    - High CPU
    - High Memory

56. 서버에 대한 설명
    - 다양한 스펙의 상품군이 존재
    - VDS는 홍콩에는 제공하지 않느다.
    - Micro 서버는 Classic 환경에서 사용 가능

57. VPC Classic 2세대 서버 Standard 서버 스펙
    - vCPU 2개 RAM 4GB

58. Archive Storage에 대한 설명
    - Swift API를 활용해서 데이터 관리

59. 쿠버네티스 마스터 노드에 설치된 요소들
    - etcd
    - apiserver
    - scheduler

60. RAID 1(미러) 설명
    - 단순 볼륨에 비해 읽기 속도가 뛰어나다.

61. 사용 가능한 OS항목
    - CentOS
    - Windows
    - Ubuntu

62. 리눅스 HTTPD 서버의 로그파일 위치
    - /var/log/httpd

63. GPU 서버에 대한 설명
    - PCI Pass Throught 방식으로 제공한다.

64. 블록 스트리지 디스크 타입 변경
    - 서버를 정지시킨 후 스토리지를 부착시킨 후 스냅샷 생성, 스토리지를 생성하며 디스크 타입을 변경

65. 베어 메탈
    - 몇가지 정해진 스펙 군에서 이용가능
    - 제공되는 OS로 Oracle Linux가 있다.
    - 디스크 구성은 RAID 1+0 및 RAID 5로 할 수 있다.

66. NAS 스토리지 
    - NAS 볼륨의 최대 용량은 10TB이다. 

67. 오토스케일링 설명
    - 헬스 체크 방식은 LoadBalancer와 서버 방식을 제공한다.
    - ASG 그룹에는 항상 최댓값 수만큼의 서버가 유지된다.

68. 여러 개의 하드 디스크에 일부 중복된 데이터를 나눠 저장하는 기술 
    - RAID

69. VPC 환경에서 내 서버 이미지에대한 설명
    - 서버가 운영중인 상태에서도 생성이 가능하다.

70.  VM으로부터 간섭현상을 줄일 수 있는 서버 타입
    - Hight CPU
    - Bare Metal
    - Hight-memory

71. 유사 서버 생성시 기존 서버의 설정 내용이 반영되는 항목은?
    - Init Script

72. Block Storage에 대한 설명
    - 기본 스토리지(=root 볼륨)가 디스크 타입과 무관하게 추가 스토리지는 HDD/SSD 모든 타입 볼륨 할당 가능하다.

73. 분산 파일 시스템
    - CODA

74. Object Storage API를 제공하는 리전
    - 미국 서부
    - 싱가포르
    - 독일

75. Block Storage에 대한 설명
     - VM 상태에 따라 볼륨 detach가 불가능 할 수도 있다.

76. 파일 시스템중 파일의 시작위치와 크기를 가지고 데이터를 저장하는 방식으로 고전적인 파일 시스템 구조이며 단순하지만 데이터 공간에 대한 낭비가 심한 파일시스템 방식은?
    - 연속 할당 방식

77. 서버를 확장성 있게 구성하거나 관리할 필요 없이 비즈니스 로직 코드로 서비스를 구성할 수 있는 상품은?
    - Colud Functions

78. 리눅스 LVM을 구성하고자 할때 LVM구성이 올바른 멸령어 사용 순서
    -  fsidk > pvcreate > vgcreate > lvcreate

79. 서버 이미지 빌더 
    - 서버 이밎 생성에 사용되는 Packet 용 스크립트를 생성하고 관리하도록 도와주는 상품이다.
    - 오픈 소스인 Packer 를 활용해서 구현되는 것이다.
    - 템플릿에 대한 버전 관리 기능을 제공핟ㄴ다.

80. 서버에 대한 설명
    - 서버를 정지한 후엔 서버 스펙 변경 가능
    - 디스는 SSD 타입과 HDD타입을 제공한다.
    - 네이버 클라우드 플랫폼 안의 다른 상품들과 연계하여 사용 가능

81.  Storage 상품
    - NAS
    - Block Storage

82. Container Registry
    - Private Endpoint 구성이 가능
    - Object Storage를 저장소로 사용한다.
    - 컨테이너 취약점 분석기능 제공

83. NAS 볼륨 용량 증설 단위
    - 100GB

84. 서버 생성되면 기본 네트워크 링크 속도   
    - 1Gbps

85. VPC환경 기준, Zone에 종속적인 상품
    - Public Subnet
    - Private Subnet
    - NAT Gateway
    
86. 쿠버 네티스 Ingress
    - 외부에서 오는 Traffic 들을 클러스터 내부의 Service로 라우팅하기 위한 규칙의 집합이다.
    - Service타입 지정은 Node Port혹은 로드 밸런서 지정을 하여야 한다.
    - NCR은 호스트 기반 및 URL NICOND

87. MC(Main Console)에서 보여지는 서버 호스트 네임을 변경하는 법
    - 콘솔에서 서버 이름 변경을 선택하여 호스트명을 변경한다.

88. 전가 상화 
    - 하이퍼 바이저 위 구동할 수 있는 게스트 OS 종류에 제약이 없다.

89. Block Storage 
    - VM 당 최대 15개의 추가 볼륨을 attach 할 수 있다.

90. VPC 환경 ACG에 대한 설명
    - 서버 NIC에 매핑된다.
    - in bound/outbound 룰 설정이 모두 가능
    -    서버 생성시 필수적으로 매핑해야하는 요소이다.
