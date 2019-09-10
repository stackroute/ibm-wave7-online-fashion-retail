import { Component, OnInit } from '@angular/core';
import { ReportServiceService } from '../report-service.service';
import { Chart } from 'chart.js';
import CanvasJS from 'canvasjs';

@Component({
  selector: 'app-dashboardreports',
  templateUrl: './dashboardreports.component.html',
  styleUrls: ['./dashboardreports.component.css']
})
export class DashboardreportsComponent implements OnInit {

  BarChart = [];
  designerCount: number;
  supplierCount: number;
  manufacturerCount: number;


  constructor(private reports: ReportServiceService) { }

  ngOnInit() {

    this.reports.getReport().subscribe(res => {
      console.log("response is ", res);
      this.designerCount = res[0];
      this.supplierCount = res[1];
      this.manufacturerCount = res[2];
      this.BarChart = new Chart('barChart',
              {
                type: 'bar',
                animationEnabled: true,
                data:
                {
                  labels: ["designers", "suppliers", "manufacturer"],
                  datasets:
                    [{
                      label: 'number of users registered',
                      data: [this.designerCount, this.supplierCount, this.manufacturerCount],
                      // data: [12, 20, 30],
                      fill: true,
                      lineTension: 1,
                      borderColor: "black",
                      borderWidth: 2
                    }]
                },
                options:
                {
                  title: {
                    text: "",
                    display: true,
                    responsive: true
                  },
                  scales: {
                    yaxes: [{

                      ticks: {
                        beginAtZero: true,
                         viewportMinimum: 0,
                      }
                    }]
                  }
                }
              }
            );
    });

    this.reports.getDesignReport().subscribe(res => {
          console.log("response is ", res);
          this.designerCount = res[0]
          this.BarChart = new Chart('barChart1',
                  {
                    type: 'bar',
                    color:'red',
                    animationEnabled: true,
                    data:
                    {
                      labels: ["designs uploaded"],
                      datasets:
                        [{
                          label: 'number of designs',
                          data: [this.designerCount],
                          backgroundColor:['red'],
                          // data: [12, 20, 30],
                          fill: true,
                          lineTension: 1,
                          borderColor: "black",
                          borderWidth: 2
                        }]
                    },
                    options:

                    {
                      title: {
                        text: "",
                        display: true,
                        responsive: true
                      },
                      scales: {
                        yaxes: [{
                          ticks: {
                            beginAtZero: true,
                             min: 0
                          }
                        }]
                      }
                    }
                  }
                );
        })
     }
  }



