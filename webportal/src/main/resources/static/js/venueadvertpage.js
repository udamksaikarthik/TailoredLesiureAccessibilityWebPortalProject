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