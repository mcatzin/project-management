const chartDataStr = decodeHtml(chartData); 

const chartJsonArray = JSON.parse(chartDataStr);

const arrayLength = chartJsonArray.length;
const numericData = [];
const labelData= [];

for(let i = 0;i< arrayLength;i++){
	numericData[i] = chartJsonArray[i].value;
	labelData[i] = chartJsonArray[i].label;
}

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd","#8e5ea2","#3cba9f"],
            data: numericData,
        }]
    },

    // Configuration options go here
    options: {
    	title: {
    		display: true,
    		text: "Project Statuses"
    	}
    }
});
 
 
 function decodeHtml(html){
	 const txt = document.createElement("textarea");
	 txt.innerHTML = html;
	 return txt.value;
 }