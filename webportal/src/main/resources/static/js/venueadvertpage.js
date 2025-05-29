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
  
function showMediaFullscreen(element) {
    const modal = document.getElementById('fullscreen-modal');
    const modalImage = document.getElementById('modal-image');
    const modalVideo = document.getElementById('modal-video');
    
    // Clear previous content
    modalImage.style.display = 'none';
    modalVideo.style.display = 'none';

    if (element.tagName === 'IMG') {
        modalImage.src = element.src;
        modalImage.style.display = 'block';
    } else if (element.tagName === 'VIDEO') {
        modalVideo.src = element.querySelector('source').src;
        modalVideo.style.display = 'block';
    }

    modal.style.display = 'flex';
}

function closeMediaFullscreen() {
    const modal = document.getElementById('fullscreen-modal');
    const modalImage = document.getElementById('modal-image');
    const modalVideo = document.getElementById('modal-video');
    
    modal.style.display = 'none';
    modalImage.src = '';
    modalVideo.src = '';
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

const butterfly_logo_id_1 = document.getElementById("butterfly_logo_id_1")
const butterfly_logo_id_2 = document.getElementById("butterfly_logo_id_2")
const butterfly_logo_id_3 = document.getElementById("butterfly_logo_id_3")
const butterfly_logo_id_4 = document.getElementById("butterfly_logo_id_4")
const butterfly_logo_id_5 = document.getElementById("butterfly_logo_id_5")
let selected_rating = document.getElementById("selected_rating");
function butterfly_fill(rating){
	console.log("Inside butterfly_fill function")
	console.log("Rating: "+rating)
	console.log("Initial selected rating: "+selected_rating.value)
	
	if(rating === 1 ){
		butterfly_logo_id_1.src = "/images/butterfly_fill.png"
		butterfly_logo_id_2.src = "/images/butterfly.png"
		butterfly_logo_id_3.src = "/images/butterfly.png"
		butterfly_logo_id_4.src = "/images/butterfly.png"
		butterfly_logo_id_5.src = "/images/butterfly.png"
	}
	
	if(rating === 2 ){
		butterfly_logo_id_1.src = "/images/butterfly_fill.png"
		butterfly_logo_id_2.src = "/images/butterfly_fill.png"
		butterfly_logo_id_3.src = "/images/butterfly.png"
		butterfly_logo_id_4.src = "/images/butterfly.png"
		butterfly_logo_id_5.src = "/images/butterfly.png"
	}
	
	if(rating === 3 ){
		butterfly_logo_id_1.src = "/images/butterfly_fill.png"
		butterfly_logo_id_2.src = "/images/butterfly_fill.png"
		butterfly_logo_id_3.src = "/images/butterfly_fill.png"
		butterfly_logo_id_4.src = "/images/butterfly.png"
		butterfly_logo_id_5.src = "/images/butterfly.png"
	}
	
	if(rating === 4 ){
		butterfly_logo_id_1.src = "/images/butterfly_fill.png"
		butterfly_logo_id_2.src = "/images/butterfly_fill.png"
		butterfly_logo_id_3.src = "/images/butterfly_fill.png"
		butterfly_logo_id_4.src = "/images/butterfly_fill.png"
		butterfly_logo_id_5.src = "/images/butterfly.png"
	}
	
	if(rating === 5 ){
		butterfly_logo_id_1.src = "/images/butterfly_fill.png"
		butterfly_logo_id_2.src = "/images/butterfly_fill.png"
		butterfly_logo_id_3.src = "/images/butterfly_fill.png"
		butterfly_logo_id_4.src = "/images/butterfly_fill.png"
		butterfly_logo_id_5.src = "/images/butterfly_fill.png"
	}
	
	selected_rating.value = rating;
	console.log("Final selected rating: "+selected_rating.value)
	
}