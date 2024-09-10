const filters = {
			    location: [],
			    tag: []
			};

			// 모든 체크박스 요소 가져오기
			const checkboxes = document.querySelectorAll('.filter_box input[type="checkbox"]');

			// 체크박스가 변경될 때마다 호출될 함수 정의
			function filterPosts() {
			    const posts = document.querySelectorAll('.post');

			    posts.forEach(post => {
			        let shouldDisplay = true;

			        // 위치 필터링
			        if (filters.location.length > 0) {
			            const location = post.querySelector('.location').textContent;
			            if (!filters.location.includes(location)) {
			                shouldDisplay = false;
			            }
			        }

			        // 태그 필터링
			        if (filters.tag.length > 0) {
			            const tags = post.querySelector('.tag').textContent.split(',');
			            const matchingTags = filters.tag.filter(tag => tags.includes(tag));
			            if (matchingTags.length === 0) {
			                shouldDisplay = false;
			            }
			        }

			        if (shouldDisplay) {
			            post.style.display = 'block';
			        } else {
			            post.style.display = 'none';
			        }
			    });
			}

			// 체크박스 변경 이벤트에 필터링 함수 연결
			checkboxes.forEach(checkbox => {
			    checkbox.addEventListener('change', function() {
			        // 위치 체크박스일 때
			        if (checkbox.closest('.location_filter_box')) {
			            if (checkbox.checked) {
			                filters.location.push(checkbox.value);
			            } else {
			                filters.location = filters.location.filter(location => location !== checkbox.value);
			            }
			        }
			        // 태그 체크박스일 때
			        else if (checkbox.closest('.tag_filter_box')) {
			            if (checkbox.checked) {
			                filters.tag.push(checkbox.value);
			            } else {
			                filters.tag = filters.tag.filter(tag => tag !== checkbox.value);
			            }
			        }
			        // 필터링 적용
			        filterPosts();
			    });
			});

			// 페이지 로드 시 필터링 함수 실행하여 초기 상태 설정
			filterPosts();