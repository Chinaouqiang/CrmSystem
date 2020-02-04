$(function(){
	/*男女比例图*/
	$.post($("#contextPath").val()+"/pages_public/File!SexR",type='json',function(data){
		var result=eval('('+data+')');
		var boy=eval('('+result.boy+')')
		var girl=eval('('+result.girl+')')
			var chart = Highcharts.chart('3D', {
				chart: {
						type: 'pie',
						options3d: {
								enabled: true,
								alpha: 45,
						}
				},
				title: {
						text: '访客男女比例'
				},
				subtitle: {
						text: '子戈信息数据分析3D环形图'
				},
				tooltip: {
					pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
				},
				plotOptions: {
						pie: {
								innerSize: 100,
								depth: 45
						}
				},
				series: [{
					dataLabels : {
						enabled : true
						,distance: -70
					},
					name: '男女比例',
					data: [
						['女性', girl],
						['男性', boy]
					]
					
				}]
		});
	   });
	
/*	时间段人数图*/
	$.post($("#contextPath").val()+"/pages_public/File!newDay",type='json',function(data){
		var result=eval('('+data+')');
		var chart = Highcharts.chart('DayVistor',{
			chart: {
				type: 'column',
				options3d: {
					enabled: true,
					alpha: 15,
					beta:12,
					viewDistance: 25,
					depth: 40
				},
				marginTop: 80,
				marginRight: 40
			},
			title: {
				text: '各个时间段男女比例及总'
			},
			xAxis: {
				categories: ['00:00', '01:00', '02:00', '03:03', '04:00', '05:00', '06:00', '07:00', '08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00', '23:59'],
			},
			yAxis: {
				allowDecimals: false,
				min: 0,
				title: {
					text: '访客信息'
				}
			},
			tooltip: {
				headerFormat: '<b>{point.key}</b><br>',
				pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y} / {point.stackTotal}'
			},
			plotOptions: {
				column: {
					stacking: 'normal',
					depth: 40
				}
			},
			series: [{
				name: '男性',
				data:[eval('('+result.yn+')'),eval('('+result.en+')'),eval('('+result.san+')'),eval('('+result.sin+')'),eval('('+result.wn+')'),eval('('+result.ln+')'),eval('('+result.qn+')'),eval('('+result.bn+')'),eval('('+result.jn+')'),eval('('+result.nn+')'),eval('('+result.yyn+')'),eval('('+result.een+')'),eval('('+result.saan+')'),eval('('+result.siin+')'),eval('('+result.wwn+')'),eval('('+result.lln+')'),eval('('+result.qqn+')'),eval('('+result.bbn+')'),eval('('+result.jjn+')'),eval('('+result.enn+')'),eval('('+result.eyn+')'),eval('('+result.eeen+')'),eval('('+result.esin+')'),eval('('+result.esan+')')],
				stack: 'male'
			}, {
				name: '女性',
				data:[eval('('+result.y+')'),eval('('+result.e+')'),eval('('+result.sa+')'),eval('('+result.si+')'),eval('('+result.w+')'),eval('('+result.l+')'),eval('('+result.q+')'),eval('('+result.b+')'),eval('('+result.j+')'),eval('('+result.n+')'),eval('('+result.yy+')'),eval('('+result.ee+')'),eval('('+result.saa+')'),eval('('+result.sii+')'),eval('('+result.ww+')'),eval('('+result.ll+')'),eval('('+result.qq+')'),eval('('+result.bb+')'),eval('('+result.jj+')'),eval('('+result.en+')'),eval('('+result.ey+')'),eval('('+result.eee+')'),eval('('+result.esi+')'),eval('('+result.esa+')')],
				stack: 'male'
			}]
		
		})
	})
	
	var myDate = new Date();
	
	/*人数图*/
	$.post($("#contextPath").val()+"/pages_public/File!WeeklyData",type='json',function(data){
		var result=eval('('+data+')')
		Highcharts.chart('daynum', {
			chart: {
				type: 'cylinder',
				options3d: {
					enabled: true,
					alpha: 15,
					beta: 15,
					depth: 50,
					viewDistance: 25
				}
			},
			title: {
				text: '前七日访客统计 圆柱图'
			},
			plotOptions: {
	            series: {
	            	depth: 25,
					colorByPoint: true,
	                label: {
	                    connectorAllowed: true
	                },
	                pointStart: Date.UTC(myDate.getFullYear(),myDate.getMonth(),myDate.getDate()-7),
					
	                pointInterval: 24 * 3600 * 1000 // one day
	            }
	        },
			xAxis: {
	            type: 'datetime',
	            lineWidth: 0,
	            tickWidth: 0,
	            labels: {
	                enabled: true
	            },
	        	
	        },
			yAxis: {
				 title:{
				       text:'访客数量(人)'
				   },
				  
			},
			series: [{
				data: [eval('('+result.a+')'), eval('('+result.b+')'), eval('('+result.c+')'), eval('('+result.d+')'), eval('('+result.e+')'), eval('('+result.f+')'), eval('('+result.g+')')],
				name: '人数',
				showInLegend: false
			}]
		});
	})
	
	
	/*饼图*/
	$.post($("#contextPath").val()+"/pages_public/File!AgeRatio",type='json',function(data){
		var result=eval('('+data+')')
		Highcharts.chart('AgeRatio', {
			chart: {
				plotBackgroundColor: null,
				plotBorderWidth: null,
				plotShadow: false,
				type: 'pie'
			},
			title: {
				text: '各个年龄段访客比例'
			},
			tooltip: {
				headerFormat: '',
				pointFormat: '<span style="color:{point.color}">\u25CF</span> <b> {point.name}</b><br/>' +
				'比例: <b>{point.z}%</b><br/>' +
				'访客人数: <b>{point.y}(人)</b><br/>'
			},
			plotOptions: {
				pie: {
					allowPointSelect: true,
					cursor: 'pointer',
					dataLabels: {
						enabled: true,
						format: '<b>{point.name}</b>: {point.percentage:.1f} %',
						style: {
							color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
						}
					}
				}
			},
			series: [{
				name: '比例',
				colorByPoint: true,
				data: [{
					name: '0-17岁',
					y: eval('('+result.a+')'),
					z:eval('('+result.ae+')')
				}, {
					name: '18-30岁',
					y: eval('('+result.b+')'),
					z:eval('('+result.be+')'),
					sliced: true,
					selected: true
				}, {
					name: '31-50岁',
					y: eval('('+result.c+')'),
					z:eval('('+result.ce+')')
				}, {
					name: '51-70岁',
					y: eval('('+result.d+')'),
					z:eval('('+result.de+')')
				}, {
					name: '70以上岁',
					y:eval('('+result.e+')'),
					z:eval('('+result.ee+')')
				}]
			}]
		});
	})
	
})


 
					
					
					