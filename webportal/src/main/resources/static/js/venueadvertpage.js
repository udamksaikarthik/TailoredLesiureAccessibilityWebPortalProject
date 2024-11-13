// Function to toggle visibility of each section when button is clicked
function toggleSection(sectionId) {
    const sectionContent = document.getElementById(sectionId);
    sectionContent.style.display = sectionContent.style.display === "none" ? "block" : "none";
}


function previewFiles() {
    const previewContainer = document.getElementById('previewContainer');
    const files = document.getElementById('media').files;

    // Clear previous previews
    previewContainer.innerHTML = '';

    Array.from(files).forEach(file => {
        const fileReader = new FileReader();
        const previewItem = document.createElement('div');
        previewItem.classList.add('preview-item');

        fileReader.onload = (e) => {
            if (file.type.startsWith('image/')) {
                const img = document.createElement('img');
                img.src = e.target.result;
                previewItem.appendChild(img);
            } else if (file.type.startsWith('video/')) {
                const video = document.createElement('video');
                video.src = e.target.result;
                video.controls = true;

                // Set MIME type for the video
                video.type = file.type; // Ensure video type matches the file's MIME type
                previewItem.appendChild(video);
            }
        };

        fileReader.onloadend = () => {
            previewContainer.appendChild(previewItem);
        };

        fileReader.readAsDataURL(file); // Read file as data URL
    });
}