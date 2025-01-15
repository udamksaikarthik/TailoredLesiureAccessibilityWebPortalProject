document.addEventListener("DOMContentLoaded", () => {
    const headers = document.querySelectorAll(".section-header");

    headers.forEach(header => {
        header.addEventListener("click", () => {
            const content = header.nextElementSibling;
            content.classList.toggle("deactive");
        });
    });
});

// Preview Media
function previewMedia() {
    const previewContainer = document.getElementById('preview-container');
    const files = document.getElementById('mediaFiles').files;
    previewContainer.innerHTML = '';

    for (const file of files) {
        const reader = new FileReader();
        reader.onload = function (e) {
            const fileType = file.type.split('/')[0];
            let previewElement;

            if (fileType === 'image') {
                previewElement = document.createElement('img');
                previewElement.src = e.target.result;
                previewElement.onclick = () => showModal(e.target.result, 'image');
            } else if (fileType === 'video') {
                previewElement = document.createElement('video');
                previewElement.src = e.target.result;
                previewElement.controls = true;
                previewElement.onclick = () => showModal(e.target.result, 'video');
            }

            previewContainer.appendChild(previewElement);
        };
        reader.readAsDataURL(file);
    }
}

// Show Full-Screen Modal
function showModal(src, type) {
    const modal = document.getElementById('modal');
    const modalImage = document.getElementById('modalImage');
    const modalVideo = document.getElementById('modalVideo');

    if (type === 'image') {
        modalImage.src = src;
        modalImage.style.display = 'block';
        modalVideo.style.display = 'none';
    } else {
        modalVideo.src = src;
        modalVideo.style.display = 'block';
        modalImage.style.display = 'none';
    }

    modal.style.display = 'flex';
}

// Close Modal
function closeModal() {
    const modal = document.getElementById('modal');
    modal.style.display = 'none';
}


// Limit on media files
function validateFileCount(input) {
        const maxFiles = 5;
        const fileCountError = document.getElementById('fileCountError');

        if (input.files.length > maxFiles) {
            fileCountError.style.display = 'block'; // Show error message
            input.value = ''; // Clear the input field
        } else {
            fileCountError.style.display = 'none'; // Hide error message
        }
    }
    
function validateFileSize(input) {
        const maxSize = 10 * 1024 * 1024; // 10 MB
        for (const file of input.files) {
            if (file.size > maxSize) {
                alert(`File ${file.name} exceeds the maximum size of 10MB.`);
                input.value = ''; // Clear the input field
                break;
            }
        }
    }
    
    
  // Function to show media in fullscreen mode
function showMediaFullscreen(element) {
    const fullscreenContainer = document.getElementById('fullscreen-container');
    const fullscreenImage = document.getElementById('fullscreen-image');
    const fullscreenVideo = document.getElementById('fullscreen-video');
    const fullscreenVideoSource = document.getElementById('fullscreen-video-source');

    // Check if the clicked media is an image
    if (element.tagName === 'IMG') {
        fullscreenImage.src = element.src;
        fullscreenImage.style.display = 'block';
        fullscreenVideo.style.display = 'none';
    }

    // Check if the clicked media is a video
    if (element.tagName === 'VIDEO') {
        fullscreenVideoSource.src = element.querySelector('source').src;
        fullscreenVideo.load();
        fullscreenVideo.style.display = 'block';
        fullscreenImage.style.display = 'none';
    }

    fullscreenContainer.classList.remove('fullscreen-hidden');
}

// Function to close the fullscreen view
function closeFullscreen() {
    const fullscreenContainer = document.getElementById('fullscreen-container');
    const fullscreenImage = document.getElementById('fullscreen-image');
    const fullscreenVideo = document.getElementById('fullscreen-video');

    // Stop video playback
    fullscreenVideo.pause();

    // Hide fullscreen container
    fullscreenContainer.classList.add('fullscreen-hidden');

    // Clear image and video sources
    fullscreenImage.src = '';
    fullscreenVideo.querySelector('source').src = '';
}

let showCommentsCounter = 1;
function showComments(){
	const show_comment_btn_id = document.getElementById('show_comment_btn_id')
	const mobility_additional_comments_container_div_id = document.getElementById('mobility_additional_comments_container_div_id')
	const blind_additional_comments_container_div_id = document.getElementById('blind_additional_comments_container_div_id')
	const deaf_additional_comments_container_div_id = document.getElementById('deaf_additional_comments_container_div_id')
	const neurodiverse_additional_comments_container_div_id = document.getElementById('neurodiverse_additional_comments_container_div_id')
	console.log("Inside showComments")
	showCommentsCounter++;
	if(showCommentsCounter % 2 === 0){
		show_comment_btn_id.innerText = "Hide Venue Comments";
		mobility_additional_comments_container_div_id.classList.add('show');
		blind_additional_comments_container_div_id.classList.add('show');
		deaf_additional_comments_container_div_id.classList.add('show');
		neurodiverse_additional_comments_container_div_id.classList.add('show');
	}else{
		show_comment_btn_id.innerText = "Show Venue Comments";
		mobility_additional_comments_container_div_id.classList.remove('show');
		blind_additional_comments_container_div_id.classList.remove('show');
		deaf_additional_comments_container_div_id.classList.remove('show');
		neurodiverse_additional_comments_container_div_id.classList.remove('show');
	}
	
}